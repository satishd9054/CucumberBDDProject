package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver){
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
		//PageFactory is a class in Selenium that helps to initialize WebElements in Page Object Model (POM) 
		//using @FindBy annotations.
		//PageFactory helps to automatically locate and load web elements using @FindBy — 
		//making your Page Object classes neat and readable.
	}
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement LoginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	public void enterEmail(String emailAdd) {
	
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton() throws InterruptedException  {
		LoginBtn.click();
		Thread.sleep(2000);
	}
	
	public void clickOnLogoutButton() throws InterruptedException {
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(3000);
	}
	
	
	
	

}
