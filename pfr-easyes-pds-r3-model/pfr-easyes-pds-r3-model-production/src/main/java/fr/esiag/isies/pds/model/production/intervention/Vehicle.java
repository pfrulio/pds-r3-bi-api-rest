package fr.esiag.isies.pds.model.production.intervention;

import fr.esiag.isies.pds.model.production.AbstractModel;

/**
 * 
 * @author PFR
 *
 */
public class Vehicle extends AbstractModel {

	private VehicleCategory vehicleCategory;
	
	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}
	
	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}
}
