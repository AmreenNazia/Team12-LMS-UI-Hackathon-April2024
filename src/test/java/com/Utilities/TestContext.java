package com.Utilities;

import com.DriverFactory.BaseTest;

public class TestContext extends BaseTest {
	
public BaseTest basetest;
public PageObjectManager pageobjectmanager;

public TestContext()
{
	basetest = new BaseTest();
	pageobjectmanager = new PageObjectManager(basetest.getDriver());
}
	
public BaseTest getDrivermanager() {
	return basetest;
}

public PageObjectManager getPageObjectManager() {
	return pageobjectmanager;
}
}
