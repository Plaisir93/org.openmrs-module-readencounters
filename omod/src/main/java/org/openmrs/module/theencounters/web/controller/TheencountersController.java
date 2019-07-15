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
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.Encounter;
import org.openmrs.api.EncounterService;
import org.openmrs.Obs;
import org.openmrs.api.ObsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/theencounters/theencountersLink.form'.
 */
@Controller("${rootrootArtifactId}.TheencountersController")
//@RequestMapping(value = "module/theencounters/theencounters.form")
public class TheencountersController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	UserService userService;
	
	@Autowired
	EncounterService encounterService;
	
	@Autowired
	ObsService obsService;
	
	/** Success form view name */
	private final String ENCOUNTERS_VIEW = "/module/theencounters/theencounters";
	
	private final String OBSERVATIONS_VIEW = "/module/theencounters/plr";
	
	/**
	 * Initially called after the getUsers method to get the landing form name
	 * 
	 * @return String form view name
	 */
	@RequestMapping(value = "/theencounters", method = RequestMethod.GET)
	public String onGetEncounters() {
		return ENCOUNTERS_VIEW;
	}
	
	@RequestMapping(value = "/plr", method = RequestMethod.GET)
	public String onGetObservations() {
		return OBSERVATIONS_VIEW;
	}
	
	/**
	 * All the parameters are optional based on the necessity
	 * 
	 * @param httpSession
	 * @param anyRequestObject
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "/theencounters", method = RequestMethod.POST)
	public String onPostEncounters(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	        BindingResult errors) {
		
		if (errors.hasErrors()) {
			// return error view
		}
		
		return ENCOUNTERS_VIEW;
	}
	
	@RequestMapping(value = "/plr", method = RequestMethod.POST)
	public String onPostObservations(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	        BindingResult errors) {
		
		if (errors.hasErrors()) {
			// return error view
		}
		
		return OBSERVATIONS_VIEW;
	}
	
	/**
	 * This class returns the form backing object. This can be a string, a boolean, or a normal java
	 * pojo. The bean name defined in the ModelAttribute annotation and the type can be just defined
	 * by the return type of this method
	 */
	@ModelAttribute("users")
	protected List<User> getUsers() throws Exception {
		List<User> users = userService.getAllUsers();
		
		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		return users;
	}
	
	// fromDate and toDate generating methods for the EncounterSearchCriteria Object
	public Date defaultFromDate() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.set(fromDate.DAY_OF_MONTH, 1);
		return fromDate.getTime();
	}
	
	@ModelAttribute("observations")
	protected List<Obs> getAllObservations() throws Exception {
		List<Obs> observations = obsService.getObservations(null, null, null, null, null, null, null, null, null,
		    defaultFromDate(), Calendar.getInstance().getTime(), true);
		
		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		return observations;
	}
	
	@ModelAttribute("encounters")
	protected List<Encounter> getAllEncounters() throws Exception {
		List<Encounter> encounters = encounterService.getEncounters(null, null, defaultFromDate(), Calendar.getInstance()
		        .getTime(), null, null, null, null, null, true);
		
		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		return encounters;
	}
	
}
