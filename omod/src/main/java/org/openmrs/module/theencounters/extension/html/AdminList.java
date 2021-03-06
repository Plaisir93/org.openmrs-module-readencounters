/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.theencounters.extension.html;

import java.util.HashMap;
import java.util.Map;

import org.openmrs.module.Extension;
import org.openmrs.module.web.extension.AdministrationSectionExt;

/**
 * This class defines the links that will appear on the administration page under the
 * "theencounters.title" heading. This extension is enabled by defining (uncommenting) it in the
 * config.xml file.
 */
public class AdminList extends AdministrationSectionExt {
	
	/**
	 * @see org.openmrs.module.web.extension.AdministrationSectionExt#getMediaType()
	 */
	public Extension.MEDIA_TYPE getMediaType() {
		return Extension.MEDIA_TYPE.html;
	}
	
	/**
	 * @see org.openmrs.module.web.extension.AdministrationSectionExt#getTitle()
	 */
	public String getTitle() {
		return "theencounters.title";
	}
	
	/**
	 * @see org.openmrs.module.web.extension.AdministrationSectionExt#getLinks()
	 */
	public Map<String, String> getLinks() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("module/theencounters/theencounters.form", "Encounters of Current Month");
		map.put("theencounters/theencounters.page", "Encounters of Current Month");
		map.put("module/theencounters/plr.form", "Observations of Current Month");
		map.put("theencounters/plr.page", "Specific Concept Based Observations");
		map.put("module/theencounters/patients.form", "All The Patients");
		map.put("theencounters/patients.page", "All The Patients");
		map.put("module/theencounters/visits.form", "All The Visits");
		map.put("theencounters/visits.page", "All The Visits");
		map.put("module/theencounters/users.page", "All Users");
		return map;
	}
	
}
