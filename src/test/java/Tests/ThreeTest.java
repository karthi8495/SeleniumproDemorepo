package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass;

public class ThreeTest extends BaseClass {
	
	public WebDriver driver;
	
	@Test
	
	public void testThree() throws InterruptedException, IOException {
		System.out.println("TestThree");
		
		 driver=initializeDriver();
		
		driver.get("https://tutorialsninja.com/demo");
		Thread.sleep(2000);
		driver.close();
	}

}
