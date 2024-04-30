package com.Utilities;

public class Constant {
	//Implicit wait applies globally to the whole script and it can sometimes cause unnecessary delays
    public static final int IMPLICIT_PAGE_LOAD=15;  
    public static final int IMPLICIT_ELEMENT_WAIT_TIME=5;

//Explicit wait applies to specific web elements. It is more precise & helps avoid unnecessary delays.
    public static final int EXPLICIT_ELEMENT_WAIT_TIME=5;
    public static final String HOME_PAGE_TITLE= "LMS";
    public static final String MANAGE_USERPAGE_HEADER = "Manage User";
    public static final String USER_DETAILS_POPUP = "User Details";
    
    public static final String MANAGE_PROGRAMPAGE_HEADER = "Manage Program";
    public static final String MANAGE_BATCHPAGE_HEADER = "Manage Batch";
    public static final String LMS_TITLE = "LMS - Learning Management System";
    public static final String PROGRAM_NAVBAR_TEXT ="Program";
	public static final String USER_NAVBAR_TEXT = "User";
	public static final String LOGOUT_NAVBAR_TEXT = "Logout";
	public static final String LOGIN_TITLE = "Please login to LMS application";
	public static final String BATCH_NAVBAR_TEXT = "Batch";
	public static final String COMPANY_TITLE = "NumpyNinja";
	public static final String INPUTFIELD_ERRORMESSAGE ="Invalid username and password Please try again";
	public static final String USER_ERRORMESSAGE = "Please enter your user name";
	public static final  String PASSWORD_ERRORMESSAGE ="Please enter your password";
}
