/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.plr.fragment.controller;

import org.openmrs.api.UserService;
import org.openmrs.api.ObsService;
import org.openmrs.Patient;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

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
	
	public void controller(FragmentModel model, @SpringBean("obsService") ObsService service) {
		model.addAttribute("observations", service.getObservations(null, null, null, null, null, null, null, null, null,
		    defaultFromDate(), Calendar.getInstance().getTime(), true));
	}
}
