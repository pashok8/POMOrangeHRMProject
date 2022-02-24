package com.orangehrm.qa.pages;

import java.nio.file.AtomicMoveNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class DataImportPage {
	
	WebDriver driver;
	ElementUtil util;
	WaitUtil wait;
	Actions act;

	public DataImportPage(WebDriver driver) {
		Assert.assertNotNull(driver);
		this.driver=driver; //assign value to login page webdriver
		PageFactory.initElements(driver, this);//this is usedto  get all webelements
		 util=new ElementUtil(driver);
		 wait= new WaitUtil(driver);
		 act=new Actions(driver);
		
	}

	//locators
	
//	@FindBy(tagName="Download")
	//WebElement download;
	@FindBy(id="menu_pim_viewPimModule")
	WebElement pimTab;
		@FindBy(id="menu_pim_Configuration")
	WebElement pimConfiguration;
	@FindBy(id="menu_admin_pimCsvImport")
	WebElement pimCsvImport;
	@FindBy(id="pimCsvImport_csvFile")
	WebElement importFile;
	@FindBy(id="btnSave")
	WebElement btnUpload;
	@FindBy(id="frmPimCsvImport")
	WebElement pageheader;
	
	

	public void pimTabClick()
	{
		util.click(pimTab);
	}
	
	public void pimConfigurationClick()
	{
		util.click(pimConfiguration);
	}
	
	public void pimCsvImportClick()
	{
		util.click(pimCsvImport);
	}	
	

	public void importFileAction(String importfilepath) {
		
		act.moveToElement(pimTab).moveToElement(pimConfiguration).moveToElement(pimCsvImport).click().build().perform();
		System.out.println("lmportFileAction");
	//	util.displayCheck(pageheader);
	//	wait.waitforElementVisibility(pageheader);
		//util.displayCheck(importFile);
		System.out.println(" select importFileAction");
		importFile.sendKeys(importfilepath);
		util.click(btnUpload);
		//wait.waitForElementClick(btnUpload);
	
		
	}
		
		
	
	
	
	
}//class end
