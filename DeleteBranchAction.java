/**
 * 
 */
package com.qspiders.pnhs.Actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qspiders.pnhs.RestUtility.AssertUtility;
import com.qspiders.pnhs.RestUtility.RestAssured;

/**
 * @author nishiveg
 *
 */
public class DeleteBranchAction {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DeleteBranchAction.class);

	RestAssured restAssured = new RestAssured();
	AssertUtility assertUtils = new AssertUtility();
	
	
	public void deleteBranch(String branchName, String uri) {
		
		String actualMsg;
		actualMsg = restAssured.deleteBranchFromApp(branchName,uri);
		LOGGER.info("Actual delete message {}",actualMsg);
		
	}


}
