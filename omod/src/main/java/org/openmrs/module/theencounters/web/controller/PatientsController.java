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

import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/theencounters/theencountersLink.form'.
 */
@Controller("${rootrootArtifactId}.PatientsController")
@RequestMapping(value = "module/theencounters/patients.form")
public class PatientsController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	PatientService patientService;
	
	/** Success form view name */
	private final String VIEW = "/module/theencounters/patients";
	
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
	public String onPostEncounters(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	        BindingResult errors) {
		
		if (errors.hasErrors()) {
			// return error view
		}
		
		return VIEW;
	}
	
	@ModelAttribute("patients")
	protected List<Patient> getAllPatients() throws Exception {
		List<Patient> patients = patientService.getAllPatients();
		
		ObjectMapper mapper = new ObjectMapper();
		
		File file = new File("patients.json");
		try {
			// Serialize Java object into JSON file.
			mapper.writeValue(file, patients);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		return patients;
	}
	
}
