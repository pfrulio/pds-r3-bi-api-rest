package fr.esiag.isies.pds.model.staging.course;

import fr.esiag.isies.pds.model.staging.AbstractModel;

public class HealthPathBill extends AbstractModel {

	private Boolean paid;

	private float amount;

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
