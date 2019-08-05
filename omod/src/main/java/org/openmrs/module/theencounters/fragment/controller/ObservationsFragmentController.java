/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.theencounters.fragment.controller;

import org.openmrs.api.UserService;
import org.openmrs.api.ObsService;
import org.openmrs.Obs;
import org.openmrs.Concept;
import org.openmrs.api.ConceptService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

/**
 *  * Controller for a fragment that shows obs  
 */

public class ObservationsFragmentController {
	
	//fromDate and toDate generating methods for the EncounterSearchCriteria Object
	public Date defaultFromDate() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.set(fromDate.DAY_OF_MONTH, 1);
		return fromDate.getTime();
	}
	
	public void controller(FragmentModel model, @SpringBean("obsService") ObsService obsService,
	        @SpringBean("conceptService") ConceptService conceptService) {
		
		// The specific concept to filter the list of all the observations according to
		Concept concept = conceptService.getConcept(1284);
		
		List<Concept> concepts = new ArrayList<Concept>();
		
		concepts.add(concept);
		
		model.addAttribute("observations", obsService.getObservations(null, null, concepts, null, null, null, null, null,
		    null, defaultFromDate(), Calendar.getInstance().getTime(), true));
	}
}
