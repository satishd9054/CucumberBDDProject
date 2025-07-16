package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="SearchEmail")
	WebElement emailAddress;
	
	@FindBy(id="search-customers")
	WebElement searchButton;
	
	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
//	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
//	List<WebElement> tableColumns;
	
	
	@FindBy(id="SearchFirstName")
	WebElement firstName;
	
	@FindBy(id="SearchLastName")
	WebElement LastName;
	
	public void enterEmailAddress(String email) {
		emailAddress.sendKeys("brenda_lindgren@nopCommerce.com");
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	
//	public boolean searchCustomerByEmail(String email) {
//		boolean found=false;
//		
//	//total no. of rows in a grid
//		//total no.of columns
//		int totalRows=tableRows.size();
//		//int totalColumns=tableColumns.size();
//		
//		for(int i=1;i>=totalRows;i++) {
//			WebElement emailElement=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i + "]/td[2]"));
//			String actualEmailAddress=emailElement.getText();
//			if(actualEmailAddress.equals(email)) {
//				found=true;
//			}
//		}
//		return found;
//		
//	}
	
	
	public void enterFirstName(String firstNameTxt) {
		firstName.sendKeys(firstNameTxt);
	}
	
	public void enterLastName(String lastNameTxt) {
		LastName.sendKeys(lastNameTxt);
	}
	
	
	
	
}
