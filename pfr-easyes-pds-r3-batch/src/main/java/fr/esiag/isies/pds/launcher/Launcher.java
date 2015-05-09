package fr.esiag.isies.pds.launcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	/**
	 * Logger.
	 */
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(Launcher.class);

	/**
	 * Main class to launch the bath
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info("Batch launched");
		Launcher obj = new Launcher();
		obj.run();
	}

	/**
	 * Run the batch
	 */
	private void run() {
		try {
			String[] springConfig = { "/applicationContext-batch.xml" };
			ApplicationContext context = new ClassPathXmlApplicationContext(
					springConfig);
			JobLauncher jobLauncher = (JobLauncher) context
					.getBean("jobLauncher");
			Job job = (Job) context.getBean("CourseJob");
			((ConfigurableApplicationContext) context).close();
			JobParameters param = new JobParametersBuilder().toJobParameters();
			jobLauncher.run(job, param);
		} catch (JobExecutionAlreadyRunningException e) {
			LOGGER.error("Erreur d'exécution du batch", e);
		} catch (JobRestartException e) {
			LOGGER.error("Erreur d'exécution du batch", e);
		} catch (JobInstanceAlreadyCompleteException e) {
			LOGGER.error("Erreur d'exécution du batch", e);
		} catch (JobParametersInvalidException e) {
			LOGGER.error("Erreur d'exécution du batch", e);
		}
	}
}
