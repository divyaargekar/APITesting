/**
 * 
 */
package com.qspiders.pnhs.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author nishiveg
 *
 */
public class BaseConfiguration {

	static String QSPIDERS_URL;
	
	static String username;
	static String password;
	
	static Properties prop;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseConfiguration.class);

	public static String getQSPIDERS_URL() {
		return QSPIDERS_URL;
	}

	public static void setQSPIDERS_URL(String qSPIDERS_URL) {
		QSPIDERS_URL = qSPIDERS_URL;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		BaseConfiguration.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		BaseConfiguration.password = password;
	}
	
	
	static{
		LOGGER.debug("Configuring qspiders propertices");
		prop = readPropertyFile();
		configureProperties();
	}
	
	public static Properties readPropertyFile(){
		
		if(null == prop){
			prop = new Properties();
			FileInputStream input = null;
			String automationHome = System.getenv("QSPIDERAUTOMATION_HOME");
			if(automationHome == null){
				LOGGER.debug("Please set the enviromment variable QSPIDERAUTOMATION_HOME to automation.cfg file");
				System.exit(-1);
			}
			try{
				input = new FileInputStream(automationHome + File.separator+"automation.cfg");
				prop.load(input);
				
			}catch(IOException ex){
				LOGGER.error("IOException {}",ex);
				
			}finally{
				if(input !=null){
					try{
						input.close();
					}catch(IOException ex){
						LOGGER.error("IOException while closing the file");
					}
				}
			}
			
		}
		return prop;
	}
	
	
	public static void configureProperties(){
		setQSPIDERS_URL(prop.getProperty(PropertyKeyEnum.QSPIDERS_URL.getKey()));
		setUsername(prop.getProperty(PropertyKeyEnum.QSPIDERS_USERNAME.getKey()));
		setPassword(prop.getProperty(PropertyKeyEnum.QSPIDERS_PASSWORD.getKey()));
	}
	
}
