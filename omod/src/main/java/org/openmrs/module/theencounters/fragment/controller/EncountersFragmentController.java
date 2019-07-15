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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.*;
import java.util.Date;
import java.util.Calendar;
//import org.openmrs.parameter.EncounterSearchCriteria;
import org.openmrs.api.UserService;
import org.openmrs.api.EncounterService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

/**
 *  * Controller for a fragment that shows all encounters according to a date range
 */
public class EncountersFragmentController {
	
	// fromDate and toDate generating methods for the EncounterSearchCriteria Object
	public Date defaultFromDate() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.set(fromDate.DAY_OF_MONTH, 1);
		return fromDate.getTime();
	}
	
	// Function wich sets the parameters of the EncounterSearchCriteria using the EncounterSearchCriteriaBuilder class.
	/*
	public EncounterSearchCriteria setEncounterSearchCriteria(Date startDate, Date endDate) {
		
		EncounterSearchCriteriaBuilder encounterSearchCriteriaBuilder = new EncounterSearchCriteriaBuilder();
		
		encounterSearchCriteriaBuilder.setPatient(null);
		encounterSearchCriteriaBuilder.setLocation(null);
		encounterSearchCriteriaBuilder.setFromDate(startDate());
		encounterSearchCriteriaBuilder.setToDate(endDate);
		encounterSearchCriteriaBuilder.setDateChanged(null);
		encounterSearchCriteriaBuilder.setEnteredViaForms(null);
		encounterSearchCriteriaBuilder.setEncounterTypes(null);
		encounterSearchCriteriaBuilder.setProviders(null);
		encounterSearchCriteriaBuilder.setVisitTypes(null);
		encounterSearchCriteriaBuilder.setVisits(null);
		encounterSearchCriteriaBuilder.setIncludeVoided(true);
		
		// Create the EncounterSearchCriteria by calling the createEncounterSearchCriteria() method
		EncounterSearchCriteria encounterSearchCriteria = new EncounterSearchCriteria();
		encounterSearchCriteria = encounterSearchCriteriaBuilder.createEncounterSearchCriteria();
		return encounterSearchCriteria;
	}
	*/
	public void controller(FragmentModel model, @SpringBean("encounterService") EncounterService service) {
		// model.addAttribute("encounters",
		//	service.getEncounters(setEncounterSearchCriteria(defaultFromDate(), defaultToDate())));
		//model.addAttribute("fromDate", defaultFromDate());
		//model.addAttribute("toDate", defaultToDate());
		model.addAttribute("encounters", service.getEncounters(null, null, defaultFromDate(), Calendar.getInstance()
		        .getTime(), null, null, null, null, null, true));
	}
}
