/**
 * 
 */
package com.qspiders.pnhs.StepDefinition;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qspiders.pnhs.Actions.CommonUtils;
import com.qspiders.pnhs.Actions.GetBranchAction;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * @author nishiveg
 *
 */
public class GetBranchStepDefinition {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GetBranchStepDefinition.class);

	
	/*@Steps
	GetBranchAction getBranchAction;*/
	
	GetBranchAction getBranchAction = new GetBranchAction();
	CommonUtils commonUtil = new CommonUtils();

	
	@Given("^user access the application with the uri \"([^\"]*)\"$")
	public void the_application_is_logged_by_admin_using_the_username_and_password(
			String uri) throws Exception {
		getBranchAction.getBranchDetails(uri);
	}

	@Then("^response code '(\\d+)' should be displayed$")
	public void response_code_should_be_displayed(int statusCode) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		commonUtil.verifyStatusCode(statusCode);
	}

	@Then("^the default branches should be available$")
	public void the_default_branches_should_be_available(List<String> defaultBranchList) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		getBranchAction.verifyDefaultBranch(defaultBranchList);
	}
	
	

	@Then("^the default branches location should be present$")
	public void the_default_branches_location_should_be_present(List<Map<String, String>> expectedData)
			throws Exception {
		LOGGER.info("Printing the expected map {}",expectedData);
		getBranchAction.verifyDefaultBranchLocation(expectedData);
	}
	


}
