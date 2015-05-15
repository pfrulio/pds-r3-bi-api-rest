package fr.esiag.isies.pds.model.staging.course;

import fr.esiag.isies.pds.model.staging.AbstractModel;

/**
 * Bill of healthpath
 * @author PFR
 *
 */
public class HealthPathBill extends AbstractModel {

	/**
	 * true if paid, false otherwise
	 */
	private Boolean paid;

	/**
	 * amount of the bill
	 */
	private float amount;

	/**
	 * healthPath
	 */
	private HealthPath healthPath;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public HealthPath getHealthPath() {
		return healthPath;
	}

	public void setHealthPath(HealthPath healthPath) {
		this.healthPath = healthPath;
	}
}
