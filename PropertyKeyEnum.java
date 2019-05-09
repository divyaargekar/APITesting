/**
 * 
 */
package com.qspiders.pnhs.Config;

/**
 * @author nishiveg
 *
 */
public enum PropertyKeyEnum {

	QSPIDERS_URL("Application_URL"), 
	QSPIDERS_USERNAME("Username"), 
	QSPIDERS_PASSWORD("Password");

	private String key;

	PropertyKeyEnum(String key1) {
		this.key = key1;
	}

	public String getKey() {
		return this.key;
	}

}
