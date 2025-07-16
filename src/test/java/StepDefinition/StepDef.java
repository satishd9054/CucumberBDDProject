package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {

	@Before
	public void setup()  {
		
		readConfig=new ReadConfig();
		
		
		log=LogManager.getLogger("StepDef");
		System.out.println("Setup method executed...");
		
		String browser=readConfig.getBrowser();
		switch(browser.toLowerCase()) {
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		break;
		
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
			
		default:
			driver=null;
			break;
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		log.info("Setup executed..");
		
	}

//	@Before("@sanity")
//	public void setup1() {
//		System.out.println("SETUP-1 method executed...");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//	}

	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginPg = new LoginPage(driver);
		addNewCustPage = new AddNewCustomerPage(driver);
		searchCustomerPg = new SearchCustomerPage(driver);
		
		log.info("User launch Chrome Browser..");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("URL Opened..");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String passwordd) throws InterruptedException {
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(passwordd);
		log.info("Email & Password address entered..");
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		Thread.sleep(3000);
		loginPg.clickOnLoginButton();
		Thread.sleep(5000);
		log.info("Login Button clicked..");
	}

	/// Login feature
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			log.warn("Login feature: Page title matched");
			org.junit.Assert.assertTrue(true);
		} else {
			
			org.junit.Assert.assertTrue(false);
			log.warn("Login feature: Test Failed");
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		loginPg.clickOnLogoutButton();
		log.info("User clicked on Logout link..");
	}



	//////////////////////////////////////////////////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = addNewCustPage.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			log.info("user_can_view_dashboard test PASSED");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.warn("user_can_view_dashboard test FAILED");
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		log.info("user menu clicked");
		addNewCustPage.clickOnCustomerMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		
		addNewCustPage.clickOnCustomerMenuItem();
		log.info("Customer menu Item clicked");
		Thread.sleep(2000);
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addNewCustPage.clickOnAddNew();
		log.info("Clicked on ADD new button");
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPage.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			log.info("User can view Add new customer page- PASSED");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.info("User can view Add new customer page- FAILED");
		}

	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		Thread.sleep(3000);
		// addNewCustPage.enterEmail("test5@gmail.com");
		addNewCustPage.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPage.enterPassword("Test123");
		addNewCustPage.enterFirstName("Samay");
		addNewCustPage.enterLastName("rana");
		addNewCustPage.MaleGenderCheckbox();
		addNewCustPage.companyName("XYZ Comany");
		addNewCustPage.adminComment("This is Automation Testing");
		
		log.info("Customer Informations entered");

	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		Thread.sleep(2000);
		addNewCustPage.clickOnSaveButton();
		log.info("Clicked on Save button");
		Thread.sleep(2000);
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expectedConfirmationMsg)) {
			
			Assert.assertTrue(true);
			log.info("user can view confirmation message - PASSED");
		} else {
			Assert.assertTrue(false);
			log.info("user can view confirmation message - FAILED");
		}
	}

/////////////////////////////////////////

	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustomerPg.enterEmailAddress("brenda_lindgren@nopCommerce.com");
		log.info("Email address entered");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustomerPg.clickOnSearchButton();
		log.info("user clicked on Search button");
	}

//@Then("User should found Email in the Search table")
//public void user_should_found_email_in_the_search_table() throws InterruptedException {
//	Thread.sleep(2000);
//    String expectedEmail="brenda_lindgren@nopCommerce.com";
//    Assert.assertTrue(searchCustomerPg.searchCustomerByEmail(expectedEmail));
//    if(searchCustomerPg.searchCustomerByEmail(expectedEmail)==true) {
//    	Assert.assertTrue(true);
//    }else {
//    	Assert.assertTrue(false);
//    }

//}

////////////////////////////////////////////////////

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustomerPg.enterFirstName("Steve");
		log.info("Customer First name entered");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustomerPg.enterLastName("Gates");
		log.info("Customer Last name entered");
	}

//@Then("User should found Name in the Search table")
//public void user_should_found_name_in_the_search_table() {
//    
//}

	//@After
	public void teardown(Scenario sc) {
		System.out.println("Tear Down method executed");
	
				String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//scenario interface->isfailed
				
				if(sc.isFailed()==true)
				{
					String filePath="C:\\AutomationProject2024\\BDD projects\\CucumberFrameWork\\Screenshots\\Failed_Screenshot"+timeStamp+".png";
					TakesScreenshot ts=((TakesScreenshot)driver);
					File source=ts.getScreenshotAs(OutputType.FILE);
					File destination=new File(filePath);
					try {
						FileUtils.copyFile(source, destination);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		
		driver.quit();
	}
	
	@AfterStep
	public void assScreenshot(Scenario scenario) {
		
		if(scenario.isFailed()) {
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			//attach image file report (data,media type,name of the attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
}

//@BeforeStep
//public void beforeStepMethodDemo() {
//	System.out.println("This is Before step...");
//}
//
//@AfterStep
//public void afterStepMethodDemo() {
//	System.out.println("This is after step...");
//}


