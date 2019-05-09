/**
 * 
 */
package com.qspiders.pnhs.StepDefinition;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qspiders.pnhs.Actions.CommonUtils;
import com.qspiders.pnhs.Actions.DeleteBranchAction;
import com.qspiders.pnhs.Actions.GetBranchAction;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nishiveg
 *
 */
public class DeleteBranchStepDefinition {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteBranchStepDefinition.class);
	
	DeleteBranchAction deleteBranch = new DeleteBranchAction();
	
	@When("^user delete the added branch \"([^\"]*)\" on the uri \"([^\"]*)\"$")
	public void deleteBranch(String branchName,String uri){
	
		deleteBranch.deleteBranch(branchName,uri);
	}


}
