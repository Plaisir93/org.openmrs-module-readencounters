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

import java.util.HashMap;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.*;
import java.util.Date;
import java.util.Calendar;
//import org.openmrs.parameter.EncounterSearchCriteria;
import org.openmrs.api.UserService;
import org.openmrs.api.EncounterService;
import org.openmrs.Encounter;
import org.openmrs.EncounterType;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.io.FileWriter;

/**
 *  * Controller for a fragment that shows all encounters according to a date range
 */
public class EncountersFragmentController {
	
	// fromDate and toDate generating methods for the EncounterSearchCriteria Object
	public Date defaultFromDate() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.set(fromDate.YEAR, 2014);
		fromDate.set(fromDate.MONTH, 1);
		fromDate.set(fromDate.DAY_OF_MONTH, 1);
		return fromDate.getTime();
	}
	
	public void controller(FragmentModel model, @SpringBean("encounterService") EncounterService service) {
		List<Encounter> encounters = service.getEncounters(null, null, defaultFromDate(), Calendar.getInstance().getTime(),
		    null, null, null, null, null, true);
		
		//HashMap<String, String> encs = new HashMap<String, String>();
		/*
		for (Encounter e : encounters) {
			encs.put("encounter type id", "" + e.getEncounterType.toString());
		}
		*/
		Gson gson = new Gson();
		FileWriter writer = null;
		ArrayList<Encounter> arrayEncounters = new ArrayList<Encounter>();
		
		try {
			writer = new FileWriter("fencounters.json");
			for (Encounter e : encounters) {
				arrayEncounters.add(e);
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		gson.toJson(arrayEncounters, writer);
		model.addAttribute("encounters", encounters);
	}
}
