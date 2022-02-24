package com.orangehrm.qa.testcases;

import org.testng.asserts.SoftAssert;

import com.orangehrm.qa.constants.Constants;
import com.orangehrm.qa.pages.AddUserPage;
import com.orangehrm.qa.pages.AdminPage;
import com.orangehrm.qa.pages.DashboardPage;
import com.orangehrm.qa.pages.DataImportPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class BasePageTest {
	WebDriver driver;
	WaitUtil wait;
	SoftAssert sf;
	public LoginPage loginpage;
	public AdminPage adminpage;
	public AddUserPage adduserpage;
	public DataImportPage dataimportpage;
	public DashboardPage  dashboardpage;
	
	ElementUtil util=new ElementUtil();
	public String url=util.getBaseurl();	//getting url from baseurl method defined in ElementUtil class
	public String user=util.getUsername();
	public String pass=util.getPassword();

	

 //selecting browser
	@Parameters("browser")
  @BeforeClass(alwaysRun=true)
  public void beforeClass(String browsername) {
	  
	String path=System.getProperty("user.dir");
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",path+ElementUtil.getPropertyValue("chromepath"));
		driver =new ChromeDriver();
	}
	else if(browsername.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",path+ElementUtil.getPropertyValue("firefoxpath"));
		
		FirefoxOptions ff=new FirefoxOptions();
		ff.setAcceptInsecureCerts(false);
		driver=new FirefoxDriver(ff);
	}

	else if(browsername.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver",path+ElementUtil.getPropertyValue("edgepath"));
		
		driver=new EdgeDriver();
	}
	
	driver.get(url);
	driver.manage().window().maximize();
	loginpage=new LoginPage(driver);
	adminpage=new AdminPage(driver);
	adduserpage =new AddUserPage(driver);
	dataimportpage=new DataImportPage(driver);
	dashboardpage =new DashboardPage(driver);
	util=new ElementUtil(driver);
	sf =new SoftAssert();
	wait=new WaitUtil(driver);
	wait.implicitwait(10);

	}
	
	//take screenshot code
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			takeScreenShotOnFailure(iTestResult.getName());

		}
	}

	public String takeScreenShotOnFailure(String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());


		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination =Constants.screenShot_path + name + dateName + ".png";

		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

 

  @AfterClass
  public void tearDown() {
	  
// driver.close();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
