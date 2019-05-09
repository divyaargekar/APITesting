/**
 * 
 */
package com.qspiders.pnhs.StepDefinition;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qspiders.pnhs.Actions.AddBranchAction;
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
public class AddBranchStrepDefinition {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AddBranchStrepDefinition.class);
	
	AddBranchAction addBranchAction = new AddBranchAction();

	@Given("^user add the branch into the applicaiton with the uri \"([^\"]*)\"$")
	public void user_add_the_branch_into_the_applicaiton_with_the_uri(
			String addBranchUri, Map<String,String> addBranchMapTestData) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		LOGGER.info("Printing the add branch data {}",addBranchMapTestData);
		addBranchAction.addBranchInToApp(addBranchMapTestData,addBranchUri);
		
	}
	
	@Then("^message \"([^\"]*)\" should be displayed$")
	public void verifyMsg(String message){
	LOGGER.info("expected message {}",message);
	addBranchAction.getMessage(message);
	}

}
