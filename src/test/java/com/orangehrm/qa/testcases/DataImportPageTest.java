package com.orangehrm.qa.testcases;



import org.testng.annotations.Test;

import com.orangehrm.qa.constants.Constants;

public class DataImportPageTest extends BasePageTest {
	
	
	@Test(priority=1,groups={"sanity"})
	public void verifyLogin()
	{
		loginpage.loginAction(user,pass);
		 String title= driver.getTitle();
		 sf.assertEquals(title, Constants.loginpagetitle);
		sf.assertAll();
	}
	
  @Test(priority=2,groups={"sanity"})
  public void verifyUploadFile() {
	  sf.assertNotNull(driver);
//	  dataimportpage.pimTabClick();
//	  dataimportpage.pimConfigurationClick();
//	  dataimportpage.pimCsvImportClick();
	  System.out.println(Constants.importFile_filepath);
	  dataimportpage.importFileAction(Constants.importFile_filepath);
	  
	  sf.assertAll();
	  
  }
}
