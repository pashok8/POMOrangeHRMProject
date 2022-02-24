package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.qa.constants.Constants;

public class LoginPageTest extends BasePageTest {
  @Test
  public void loginTest() {
	  
	 loginpage.loginAction(user,pass);
	 String title= driver.getTitle();
	 Assert.assertEquals(title, Constants.loginpagetitle);
	 
  }
}
