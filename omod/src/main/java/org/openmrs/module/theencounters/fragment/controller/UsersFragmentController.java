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

import java.util.List;
import org.openmrs.api.UserService;
import org.openmrs.User;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *  * Controller for a fragment that shows all users  
 */
public class UsersFragmentController {
	
	public void controller(FragmentModel model, @SpringBean("userService") UserService service) {
		List<User> users = service.getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		
		File file = new File("users.json");
		try {
			// Serialize Java object into JSON file.
			mapper.writeValue(file, users);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("users", users);
	}
}
