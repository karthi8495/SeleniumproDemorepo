package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import resources.BaseClass;

public class RegistrationTest extends BaseClass {
	
	Logger log;
	public WebDriver driver;

	@Test
   
	public void Registration() throws IOException, InterruptedException {

		
		RegistrationPage registerpage=new RegistrationPage(driver);
		
		   registerpage.myaccountdropdown().click();
		   log.debug("Clicked on My Account dropdown");
		   registerpage.register().click();
		   log.debug("Clicked on Register");
		  
		 Thread.sleep(3000);  
		 
		   registerpage.firstname().sendKeys("priya");
		   log.debug("Entered First Name");
		   registerpage.lastname().sendKeys("karthi");
		   log.debug("Entered Last Name");
		   registerpage.createemail().sendKeys("dummy@test.com");
		   log.debug("Entered Email");
		   registerpage.phone().sendKeys("9654165236");
		   log.debug("Entered PhoneNumber");
		   registerpage.createpassword().sendKeys("Test@123");		   
		   log.debug("Entered Password");
		   registerpage.conformpassword().sendKeys("Test@123");
		   log.debug("Entered Conform password");
		   registerpage.policy().click();
		   log.debug("Policy Checkbox Clicked");
		   registerpage.clickcontinue().click();
		   log.debug("Clicked continue Button");



	}
		
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		
		log.debug("Browser got launched");
		
		driver.get(prop.getProperty("url"));
		
		log.debug("Navigated to application URL");
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
		
		log.debug("Browser got closed");
		
	}


}

	


