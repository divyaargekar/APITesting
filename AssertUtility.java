/**
 * 
 */
package com.qspiders.pnhs.RestUtility;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nishiveg
 *
 */
public class AssertUtility {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssertUtility.class);
	
	public void assertEqualStatusCode(int expectedCode, int actualCode){
		try{
			assertThat(actualCode).isEqualTo(expectedCode);
		}catch(Exception e){
			LOGGER.error("Exception while asserting the code {}",e);
		}
	}
	
	public void assertTrueWithMessage(String msg, boolean value){
		LOGGER.info("Asserting for true with the message {} and boolean value {}",msg,value);
		try{
			Assert.assertTrue(msg, value);
		}catch(Exception e){
			LOGGER.error("Exception while verifying the boolean value for true {}",e);
		}
	}

	public void assertMsg(String expectedMsg, String actualMsg) {
		LOGGER.info("Assert the message");
		try{
			assertThat(actualMsg).isEqualToIgnoringCase(expectedMsg);
		}catch(Exception e){
			LOGGER.error("Exception while asserting the message");
		}
		
	}


}
