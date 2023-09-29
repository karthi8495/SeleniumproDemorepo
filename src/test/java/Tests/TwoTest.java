package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass;

public class TwoTest extends BaseClass{
	
	
	public WebDriver driver;
	
	@Test
	
	public void testTwo() throws IOException, InterruptedException {
		System.out.println("TestTwo");
		 driver=initializeDriver();
		
		driver.get("https://tutorialsninja.com/demo");
		Thread.sleep(2000);
		driver.close();
	}

}
