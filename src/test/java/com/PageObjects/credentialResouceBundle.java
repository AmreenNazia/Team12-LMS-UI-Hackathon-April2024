package com.PageObjects;

import java.util.ResourceBundle;

import com.Utilities.InputValueType;

public class credentialResouceBundle {

	public static ResourceBundle rb = ResourceBundle.getBundle("Config/config");

	public static String getBrowser() {
		return rb.getString("browser");
	}
	public static String getURL() {
		return rb.getString("url");
	}
 
	public static String getInvalidURL() {
		return rb.getString("InvalidUrl");
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

    public static String getTestUserName() {
    	return rb.getString("testuser");
    }

    public static String getFirstNameByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidFirstName");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumFirstName");
    	}

    	return rb.getString("validFirstName");
    }

    public static String getMiddleNameByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidMiddleName");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumMiddleName");
    	}
    	return rb.getString("validMiddleName");
    }

    public static String getLastNameByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidLastName");
    	} else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumLastName");
    	} else if(type == InputValueType.CANCNEL_INPUT) {
    		return rb.getString("cancelButtonLastNameTest");
    	}
    	return rb.getString("validLastName");
    }

    public static String getLocationByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidLocation");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumLocation");
    	}
    	return rb.getString("validLocation");
    }

    public static String getPhoneNumberByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidPhoneNumber");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumPhoneNumber");
    	}

    	return rb.getString("validPhoneNumber");
    }

    public static String getEmailByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidEmail");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumEmail");
    	}
    	return rb.getString("validEmail");
    }

    public static String getInvalidLinkedInURL(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidLinkedInURL");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumLinkedInURL");
    	}
    	return rb.getString("validLinkedInURL");
    }

    public static String getUnderGraduateByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidUnderGraduate");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumUnderGraduate");
    	}
    	return rb.getString("validUnderGraduate");
    }

    public static String getPostGraduateByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidPostGraduate");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumPostGraduate");
    	}
    	return rb.getString("validPostGraduate");
    }

    public static String getTimeZoneByType(InputValueType type) {
    	if(type == InputValueType.INVALID) {
        	return rb.getString("invalidTimezone");
    	}else if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumTimezone");
    	}
    	return rb.getString("validTimezone");
    }


	public static String getUserRoleByType(InputValueType type) {
		return rb.getString("validUserRole");
	}
	public static String getUserRoleStatusByType(InputValueType type) {
		return rb.getString("validUserRoleStatus");
	}
	public static String getVisaStatusByType(InputValueType type) {
		return rb.getString("validUserVisaStatus");
	}

	public static String getUserCommentsByType(InputValueType type) {
	 if(type == InputValueType.SPECIALCHAR_NUM) {
    		return rb.getString("specialCharNumUserComments");
    	}
		return rb.getString("validUserComments");
	}







}
