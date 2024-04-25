package com.PageObjects;

import java.util.ResourceBundle;

public class credentialResouceBundle {
	
	public static ResourceBundle rb = ResourceBundle.getBundle("Config/config");
	
	public static String getBrowser() {
		return rb.getString("browser");
	}
	public static String getURL() {
		return rb.getString("url");
	}
	
	public static String getUsername() {
        return rb.getString("user");
    }

    public static String getPassword() {
        return rb.getString("password");
    }
    public static String getInvalidUsername() {
        return rb.getString("invalidUser");
    }

    public static String getInvalidPassword() {
        return rb.getString("invalidPassword");
    }


}
