/**
 * 
 */
package com.qspiders.pnhs.Actions;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qspiders.pnhs.RestUtility.AssertUtility;
import com.qspiders.pnhs.RestUtility.RestAssured;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

/**
 * @author nishiveg
 *
 */
public class GetBranchAction {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(GetBranchAction.class);

	RestAssured restAssured = new RestAssured();
	AssertUtility assertUtils = new AssertUtility();

	public void getBranchDetails(String uri) {

		// writing the code for calling the rest api.
		restAssured.doGet(uri);

	}

	public void verifyDefaultBranch(List<String> defaultBranchList) {
		boolean listsAreSame;
		//listsAreSame = restAssured.verifyListData(defaultBranchList);
		listsAreSame = restAssured.verifyListPojoData(defaultBranchList);
		if(listsAreSame){
			assertUtils.assertTrueWithMessage("Lists are same", listsAreSame);
		}else{
			assertUtils.assertTrueWithMessage("Lists are not same", listsAreSame);
		}

	}

	public void verifyDefaultBranchLocation(
			List<Map<String, String>> expectedData) {
		boolean defaultBranchLocationAreSame;
		defaultBranchLocationAreSame = restAssured.verifyLocations(expectedData);
		LOGGER.info("returned boolean data {}",defaultBranchLocationAreSame);
		
	}


}
