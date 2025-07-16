package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
WebDriver ldriver;

public AddNewCustomerPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
}

//Find web elements on the page
@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
WebElement clickCustomers_menu;

@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
WebElement clickCustomers_menuItem;

@FindBy(xpath = "//a[@class='btn btn-primary']")
WebElement AddNewButton;

@FindBy(xpath = "//input[@id='Email']")
WebElement txtEmail;

@FindBy(xpath = "//input[@id='Password']")
WebElement txtPassword;

@FindBy(xpath ="//input[@id='FirstName']")
WebElement txtFirstName;

@FindBy(xpath= "//input[@id='LastName']")
WebElement txtLastName;

@FindBy(id="Gender_Male")
WebElement MaleGender;

@FindBy(id="Gender_Female")
WebElement FemaleGender;

@FindBy(xpath = "//input[@id='Company']")
WebElement txtCompanyName;

@FindBy(xpath = "//textarea[@id='AdminComment']")
WebElement txtAdminComment;

@FindBy(xpath = "//button[@name='save']")
WebElement clickSaveBtn;

public String getPageTitle() {
	return ldriver.getTitle();
}

public void clickOnCustomerMenu() {
	clickCustomers_menu.click();
}

public void clickOnCustomerMenuItem() {
	clickCustomers_menuItem.click();
}

public void clickOnAddNew() {
	AddNewButton.click();
}

public void enterEmail(String email) {
	txtEmail.sendKeys(email);
}

public void enterPassword(String password) {
	txtPassword.sendKeys(password);
}

public void enterFirstName(String firstname) {
	txtFirstName.sendKeys(firstname);
}

public void enterLastName(String Lastname) {
	txtLastName.sendKeys(Lastname);
}

public void MaleGenderCheckbox() {
	MaleGender.click();
}

public void FemaleGenderCheckbox() {
	FemaleGender.click();
}

public void companyName(String compName) {
	txtCompanyName.sendKeys(compName);
}

public void adminComment(String commentAdmin) {
	txtAdminComment.sendKeys(commentAdmin);
}

public void clickOnSaveButton() {
	clickSaveBtn.click();
}


}
