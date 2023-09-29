package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.BaseClass;

public class FourTest extends BaseClass{

	public WebDriver driver;   //we are using listeners that time compulsory we put it on PUBLIC access modifier in global level
	
   @Test
	
	public void testFour() throws IOException, InterruptedException {
		System.out.println("TestFour");
		
    driver=initializeDriver();
		
		driver.get("https://tutorialsninja.com/demo");
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
		
	
	}

   
   @AfterMethod
   public void closingBrowser() {
		driver.close();
   }
   
   
}
