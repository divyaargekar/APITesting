/**
 * 
 */
package com.qspiders.pnhs.Actions;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qspiders.pnhs.RestUtility.AssertUtility;
import com.qspiders.pnhs.RestUtility.RestAssured;

/**
 * @author nishiveg
 *
 */
public class AddBranchAction {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AddBranchAction.class);
	
	RestAssured restAssured = new RestAssured();
	AssertUtility assertUtils = new AssertUtility();
	
	
	public void addBranchInToApp(Map<String, String> addBranchMapTestData,String addBranchUri) {
	
		boolean branchAddedSuccessfully = restAssured.addBranch(addBranchMapTestData,addBranchUri);
	}


	public void getMessage(String expectedMsg) {
		
		//String actualMsg = restAssured.getActualMessage(expectedMsg);
		String actualMsg = RestAssured.getStatusMessage();
		assertUtils.assertMsg(expectedMsg, actualMsg);
	}

}
