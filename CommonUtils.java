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
public class CommonUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);
	
	int responseHttpStatusCode;
	AssertUtility assertUtil = new AssertUtility();

	public void verifyStatusCode(int statusCode) {
		responseHttpStatusCode = RestAssured.getHttpStatusCode();
		assertUtil.assertEqualStatusCode(statusCode, responseHttpStatusCode);
	} 

}
