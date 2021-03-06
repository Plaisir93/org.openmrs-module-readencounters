/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.theencounters.web.controller;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Obs;
import org.openmrs.api.ObsService;
import org.openmrs.api.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/plr/plrLink.form'.
 */
@Controller("${rootrootArtifactId}.PlrController")
@RequestMapping(value = "module/theencounters/plr.form")
public class PlrController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	ObsService obsService;
	
	@Autowired
	ConceptService conceptService;
	
	/** Success form view name */
	private final String VIEW = "/module/theencounters/plr";
	
	/**
	 * Initially called after the getUsers method to get the landing form name
	 * 
	 * @return String form view name
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String onGet() {
		return VIEW;
	}
	
	/**
	 * All the parameters are optional based on the necessity
	 * 
	 * @param httpSession
	 * @param anyRequestObject
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String onPost(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	        BindingResult errors) {
		
		if (errors.hasErrors()) {
			// return error view
		}
		
		return VIEW;
	}
	
	// fromDate and toDate generating methods for the EncounterSearchCriteria Object
	public Date defaultFromDate() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.set(fromDate.DAY_OF_MONTH, 1);
		return fromDate.getTime();
	}
	
	public Date defaultToDate() {
		//DateFormat df = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
		Calendar toDate = Calendar.getInstance();
		return toDate.getTime();
	}
	
	@ModelAttribute("observations")
	protected List<Obs> getAllObservations(Date startDate, Date endDate) throws Exception {
		List<Obs> observations = obsService.getObservations(null, null, null, null, null, null, null, null, null,
		    defaultFromDate(), defaultToDate(), true);
		
		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		return observations;
	}
	
}
