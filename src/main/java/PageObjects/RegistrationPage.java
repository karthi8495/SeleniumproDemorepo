package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

WebDriver driver;	

 public RegistrationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myaccountdropdown; 
 
	@FindBy(linkText="Register")
	private WebElement register;
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement createemail;	
	
	@FindBy(id="input-telephone")
	private WebElement phone;
	
	@FindBy(id="input-password")
	private WebElement createpassword;
	
	@FindBy(id="input-confirm")
	private WebElement conformpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement policy;	
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement clickcontinue;
	
	
	public WebElement myaccountdropdown() {
		return myaccountdropdown;
	}


	public WebElement register() {
		return register;
	}

	public WebElement firstname() {
		return firstname;
	}

	public WebElement lastname() {
		return lastname;
	}

	public WebElement createemail() {
		return createemail;
	}

	public WebElement phone() {
		return phone;
	}

	public WebElement createpassword() {
		return createpassword;
	}

	public WebElement conformpassword() {
		return conformpassword;
	}


	public WebElement policy() {
		return policy;
	}
	
	public WebElement clickcontinue() {
		return clickcontinue;
	}

 
}
