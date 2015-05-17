package fr.esiag.isies.pds.utils.mapping;

import fr.esiag.isies.pds.model.staging.intervention.Intervention;

/**
 * Map HealthPath production into HealthPath Staging
 * @author PFR
 *
 */
public class InterventionMapping implements
		IMapping<fr.esiag.isies.pds.model.production.intervention.Intervention, Intervention> {

	@Override
	public Intervention mapping(
			fr.esiag.isies.pds.model.production.intervention.Intervention item) {
		Intervention mapObject = new Intervention();

		return mapObject;
	}

	}
