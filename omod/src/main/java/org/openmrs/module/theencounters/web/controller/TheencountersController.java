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

import java.sql.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.api.ObsService;
import org.openmrs.Obs;
import org.openmrs.Encounter;
import org.openmrs.api.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import org.openmrs.module.theencounters.DatabaseConnection;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/theencounters/theencountersLink.form'.
 */
@Controller("${rootrootArtifactId}.TheencountersController")
@RequestMapping(value = "module/theencounters/theencounters.form")
public class TheencountersController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	static final String DB_URL = "jdbc:mysql://localhost/test_plr";
	
	//  Database credentials
	static final String USER = "root";
	
	static final String PASS = "solutions";
	
	@Autowired
	ObsService obsService;
	
	@Autowired
	EncounterService encounterService;
	
	@Autowired
	UserService userService;
	
	/** Success form view name */
	private final String VIEW = "/module/theencounters/theencounters";
	
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
	
	/**
	 * This class returns the form backing object. This can be a string, a boolean, or a normal java
	 * pojo. The bean name defined in the ModelAttribute annotation and the type can be just defined
	 * by the return type of this method
	 */
	// fromDate and toDate generating methods for the EncounterSearchCriteria Object
	public Date defaultFromDate() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.set(fromDate.YEAR, 2009);
		fromDate.set(fromDate.MONTH, 4);
		fromDate.set(fromDate.DAY_OF_MONTH, 1);
		return fromDate.getTime();
	}
	
	public Date defaultToDate() {
		Calendar fromDate = Calendar.getInstance();
		fromDate.set(fromDate.YEAR, 2009);
		fromDate.set(fromDate.MONTH, 8);
		fromDate.set(fromDate.DAY_OF_MONTH, 1);
		return fromDate.getTime();
	}
	
	@ModelAttribute("encounters")
	protected List<Encounter> getAllEncounters() throws Exception {
		List<Encounter> encounters = encounterService.getEncounters(null, null, defaultFromDate(), defaultToDate(), null,
		    null, null, null, null, true);
		
		List<Obs> obs = obsService.getObservations(null, null, null, null, null, null, null, null, null, defaultFromDate(),
		    defaultToDate(), true);
		
		Connection conn = null;
		Statement stmt = null;
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP 3: Open a connection
			System.out.println("Connecting to the test_plr database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			
			//STEP 4: Execute a query
			System.out.println("Inserting records into the table patient");
			stmt = conn.createStatement();
			for (Obs o : obs) {
				String sql = "INSERT INTO patient (patient_id) " + "VALUES (" + o.getPersonId() + ")";
				stmt.executeUpdate(sql);
			}
			
		}
		catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally {
			//finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			}
			catch (SQLException se) {}// do nothing
			try {
				if (conn != null)
					conn.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
		return encounters;
	}
}
