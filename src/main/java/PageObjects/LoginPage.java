package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailaddressfield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	public WebElement emailaddressfield() {
		return emailaddressfield;

	}
	public WebElement passwordfield() {
		return passwordfield;
	}
	
	public WebElement loginButton() {
		return loginButton;

	}
	
	
}
