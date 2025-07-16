package StepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;


public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPage;
	public SearchCustomerPage searchCustomerPg;
	public static Logger log;
	public ReadConfig readConfig;
	
	public String generateEmailId() {
		return(RandomStringUtils.randomAlphabetic(5));
	}

}
