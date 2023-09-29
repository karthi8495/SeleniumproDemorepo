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
import resources.BaseClass;



public class LoginTest extends BaseClass {

	Logger log;
	
	public WebDriver driver;
	

	@Test(dataProvider="getLoginData")
   
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {

	
		
		
		
		LandingPage landingpage=new LandingPage(driver);

		landingpage.myaccountdropdown().click();
		
		log.debug("Clicked on My Account dropdown");

		landingpage.loginOption().click();
		
		log.debug("Clicked on login option");

		Thread.sleep(3000);

		LoginPage loginpage=new LoginPage(driver);

		loginpage.emailaddressfield().sendKeys(email);
		
		log.debug("Email addressed got entered");
		
		loginpage.passwordfield().sendKeys(password);
		
		log.debug("Password got entered");
		
		loginpage.loginButton().click();

		log.debug("Clicked on Login Button");
		
		Thread.sleep(3000);

		AccountPage accountPage=new AccountPage(driver);
		
		
		String actualResult=null;
		try {
			
			if (accountPage.editAccountInformation().isDisplayed()) {
				
				log.debug("User got logged in");
				
				actualResult="Successfull";
		}
		}catch(Exception e) {
			
			actualResult="Failure";
		}
		
    if(actualResult.equals(expectedResult)) {
			
			log.info("Login Test got passed");
			
		}else {
			
			log.error("Login Test got failed");
		}
		
	//	Assert.assertEquals(actualResult, expectedResult);
		
		
		
//		System.out.println(accountPage.editAccountInformation().isDisplayed());

//		Assert.assertTrue(accountPage.editAccountInformation().isDisplayed());

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

	@DataProvider
	
	public Object[][] getLoginData() {
		
		Object[][] data= {{"karthikeyanmadhappan@gmail.com","Karthi@123","Successfull"}};
           return data;
	}
	

}
