package fr.esiag.isies.pds.tasklet;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

import fr.esiag.isies.pds.dao.staging.utils.HibernateUtils;

/**
 * Write log of execution of the batch
 * 
 * @author PFR
 *
 */
public class WriteFileLogTasklet implements Tasklet {

	private Boolean completed;

	private Resource directory;

	private String nameOfJob;

	@Override
	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {
		//Close connection
		HibernateUtils.shutdown();
		File dir = directory.getFile();
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		Date date = new Date();
		File file = new File(dir.getAbsolutePath() + "/" + date.getTime()
				+ ".txt");
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
		String sDate = df.format(date);
		if (completed) {
			fw.append("EASYES-R3-" + nameOfJob + "-PROD-STAGING-" + sDate
					+ " : SUCCESS");
		} else {
			fw.append("EASYES-R3-" + nameOfJob + "-PROD-STAGING-" + sDate
					+ " : ERROR");
		}
		fw.flush();
		fw.close();
		return RepeatStatus.FINISHED;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Resource getDirectory() {
		return directory;
	}

	public void setDirectory(Resource directory) {
		this.directory = directory;
	}

	public String getNameOfJob() {
		return nameOfJob;
	}

	public void setNameOfJob(String nameOfJob) {
		this.nameOfJob = nameOfJob;
	}
}
