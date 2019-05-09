/**
 * 
 */
package com.qspiders.pnhs.RestUtility;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.serenitybdd.rest.SerenityRest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.graph.ElementOrder.Type;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.qspiders.pnhs.Config.BaseConfiguration;
import com.qspiders.pnhs.Domain.Branch;

/**
 * @author nishiveg
 *
 */
public class RestAssured {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RestAssured.class);

	byte[] authorization = null;
	ResponseBody responseBody = null;
	public static int httpStatusCode;
	Gson gsonLib = new Gson();
	public static String statusMessage;

	public void doGet(String uri) {

		try {
			authorization = Base64.encodeBase64(("admin" + ":" + "password")
					.getBytes());
			SerenityRest
					.given()
					.contentType("application/json")
					.header("Authorization",
							"Basic " + new String(authorization, "UTF-8"))
					.when().get("http://localhost:9088" + uri);
			responseBody = SerenityRest.then().extract().response();
			LOGGER.info("Response {}", responseBody.asString());
		} catch (Exception e) {
			LOGGER.error("Exception while calling the get API {}", e);
		}

		try {
			httpStatusCode = SerenityRest.then().extract().statusCode();
			LOGGER.info("Response status code {}", httpStatusCode);
		} catch (Exception e) {
			LOGGER.error("Exception while capturing the status code {}", e);
		}

	}

	public static int getHttpStatusCode() {
		return httpStatusCode;
	}

	public boolean verifyListData(List<String> defaultBranchList) {
		// expectedList
		List<String> defaultBranchNameList = new ArrayList<String>();
		// actualList
		List<String> actualNameList = new ArrayList<String>();
		defaultBranchNameList.addAll(defaultBranchList);
		boolean verificationFlag = false;
		//Since actual response is a list of map, we are taking that into a list of map
		List<Map<Object, Object>> actualRes = new ArrayList<Map<Object, Object>>();
		//Response body which we get from the rest assured taking into the list of class.
		actualRes = gsonLib.fromJson(responseBody.asString(), List.class);
		LOGGER.info("Actual data {}", actualRes);
		//Iterating into the list of maps. 
		for (Map map1 : actualRes) {
			// actualNameList.add(map.get("name"));
			String br;
			br = map1.get("name") + "";
			actualNameList.add(br);

		}
		if (defaultBranchNameList.size() == actualNameList.size()) {
			Collections.sort(defaultBranchNameList);
			Collections.sort(actualNameList);
			LOGGER.info("Both the sorted list expectedList {}, actual List {}",
					defaultBranchNameList, actualNameList);
			if (actualNameList.containsAll(defaultBranchNameList)) {
				verificationFlag = true;
			} else {
				verificationFlag = false;
			}
		} else {
			LOGGER.error("List size is not same ");
			verificationFlag = false;
		}
		LOGGER.info("Falg value {}", verificationFlag);
		return verificationFlag;

	}

	public boolean verifyLocations(List<Map<String, String>> expectedData) {
		boolean flag = false;
		List<Map<String, String>> actualRes = new ArrayList<Map<String, String>>();
		List<Boolean> booleanList = new ArrayList<Boolean>();
		actualRes = gsonLib.fromJson(responseBody.asString(), List.class);
		LOGGER.info("print actual data {}", actualRes);
		for (Map<String, String> expectedMap : expectedData) {
			String expectedBr;
			String expectedLoc;
			expectedBr = expectedMap.get("name");
			expectedLoc = expectedMap.get("location");
			for (Map<String, String> actualMap : actualRes) {
				if (expectedBr.equals(actualMap.get("name"))) {
					String actualLocation;
					actualLocation = actualMap.get("location");
					if (expectedLoc.equals(actualLocation)) {
						booleanList.add(true);
						LOGGER.info("print the booleanlist {}", booleanList);
						break;
					} else {
						LOGGER.info(
								"Actual location {} is not proper for the actual branch {}. "
										+ "Because expected branch name {} and expected location {} are this",
								actualLocation, actualMap.get("name"),
								expectedBr, expectedLoc);
					}
				}
			}
		}
		if (expectedData.size() == booleanList.size()) {
			flag = true;
		}
		return flag;
	}

	public boolean addBranch(Map<String, String> addBranchMapTestData,String addBranchUri) {
		boolean flag = false;
		List<Map<String,String>> branchListData = new ArrayList<Map<String,String>>();
		
		try{
			branchListData.add(addBranchMapTestData);
			LOGGER.info("Data to add the branch {}",gsonLib.toJson(branchListData));
			authorization = Base64.encodeBase64(("admin" + ":" + "password")
					.getBytes());
			responseBody = SerenityRest.given().contentType("application/json").header("Authorization",
					"Basic " + new String(authorization, "UTF-8")).when().body(gsonLib.toJson(branchListData)).accept("application/json").post("http://localhost:9088" +addBranchUri);
			
					LOGGER.info("Post called {}",responseBody.asString());
		}catch(Exception e){
			LOGGER.error("Exception while adding the branch {}",e);
		}
		
		try{
			//one way of getting the json value from the response.
			statusMessage = responseBody.jsonPath().getString("message");
			LOGGER.info("first way {}",statusMessage);
			
		}catch(Exception e){
			LOGGER.error("Exception while getting message after adding the branch {}",e);
		}
		
		return flag;
	}

/*	public String getActualMessage(String message) {
		String actualMsg = null;
		try{
			//one way of getting the json value from the response.
			statusMessage = responseBody.jsonPath().getString("message");
			LOGGER.info("first way {}",actualMsg);
			//second way
			Map<String, String> responseMap2 = gsonLib.fromJson(responseBody.asString(), Map.class);
			LOGGER.info("Second way {}",responseMap2.get("message"));
			//third way
			Map<String,String> responseMap = responseBody.as(Map.class);
			actualMsg = responseMap.get("message");
			LOGGER.info("Third way {}",responseMap.get("message"));
			
		}catch(Exception e){
			LOGGER.error("Exception while getting message after adding the branch {}",e);
		}
		
		return actualMsg;
	}
	*/
	public boolean verifyListPojoData(List<String> defaultBranchList) {
		// expectedList
		List<String> defaultBranchNameList = new ArrayList<String>();
		// actualList
		List<String> actualNameList = new ArrayList<String>();
		defaultBranchNameList.addAll(defaultBranchList);
		boolean verificationFlag = false;
		java.lang.reflect.Type fooType = new TypeToken<List<Branch>>() {}.getType();    
		List<Branch> actualRes = gsonLib.fromJson(responseBody.asString(), fooType);
		LOGGER.info("Actual data {}", actualRes);
		for (Branch branchData : actualRes) {
			// actualNameList.add(map.get("name"));
			String br;
			br  = 	branchData.getName();
			actualNameList.add(br);
		}
		if (defaultBranchNameList.size() == actualNameList.size()) {
			Collections.sort(defaultBranchNameList);
			Collections.sort(actualNameList);
			LOGGER.info("Both the sorted list expectedList {}, actual List {}",
					defaultBranchNameList, actualNameList);
			if (actualNameList.containsAll(defaultBranchNameList)) {
				verificationFlag = true;
			} else {
				verificationFlag = false;
			}
		} else {
			LOGGER.error("List size is not same ");
			verificationFlag = false;
		}
		LOGGER.info("Falg value {}", verificationFlag);
		return verificationFlag;

	}

	public String deleteBranchFromApp(String branchName, String uri) {
		String returnActualMsg = null;
		try{
			LOGGER.info("Pring the delete URI {}",BaseConfiguration.getQSPIDERS_URL()+ uri+"/"+branchName);
			LOGGER.info("Username {}, password {}",BaseConfiguration.getUsername(),BaseConfiguration.getPassword());
			authorization = Base64.encodeBase64((BaseConfiguration.getUsername() + ":" + BaseConfiguration.getPassword())
					.getBytes());
			SerenityRest
					.given()
					.contentType("application/json").accept("application/json")
					.header("Authorization",
							"Basic " + new String(authorization, "UTF-8"))
					.when().delete(BaseConfiguration.getQSPIDERS_URL() + uri+"/"+branchName);
			responseBody = SerenityRest.then().extract().response();
			LOGGER.info("Response {}", responseBody.asString());
			
		}catch(Exception e){
			LOGGER.error("Exception while deleting the branch {}",e);
		}
		
		try {
			httpStatusCode = SerenityRest.then().extract().statusCode();
			LOGGER.info("Response status code {}", httpStatusCode);
		} catch (Exception e) {
			LOGGER.error("Exception while capturing the status code {}", e);
		}
		
		try{
			//one way of getting the json value from the response.
			statusMessage = responseBody.jsonPath().getString("message");
			returnActualMsg = statusMessage;
			LOGGER.info("first way {}",statusMessage);			
		}catch(Exception e){
			LOGGER.error("Exception while getting message after adding the branch {}",e);
		}
		return returnActualMsg;
	}
	
	public static String getStatusMessage() {
		return statusMessage;
	}


	

}
