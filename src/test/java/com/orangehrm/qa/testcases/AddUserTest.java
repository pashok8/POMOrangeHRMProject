package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orangehrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;

public class AddUserTest extends BasePageTest {
	

	
	
	@Test(priority=1,groups={"sanity"})
	public void verifyLogin()
	{
		loginpage.loginAction(user,pass);
		 String title= driver.getTitle();
		 Assert.assertEquals(title, Constants.loginpagetitle);
	}
	
	@Test(dataProvider="userData",priority=2,groups={"sanity"})
	
	public void addUseractiontest(String employeename,String username,String password,String confirmpswd)
	{
		String adduserUrl=driver.getCurrentUrl();
		String expected1="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		sf.assertEquals(adduserUrl, expected1);
		adduserpage.adduserdetails(employeename,username,password,confirmpswd);
		String saveuserUrl=driver.getCurrentUrl();
		String expected2="https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser";
		sf.assertEquals(saveuserUrl, expected2);
		sf.assertAll();
		
		
		
	}
	  
	
	@DataProvider()

	public Object[][] userData() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "AddUserData");

		return data;
	}

    }
	
	

