package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddContactPage extends BasePage {
	WebDriver driver;

	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUBMIT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_ON_PROFILE_ELEMENT;
	
	String generatedName;
	public void insertFullName(String username) {
	 generatedName = username + generateRandomNo(999);
		FULL_NAME_ELEMENT.sendKeys(generatedName);

	}

	public void selectCompany(String company) {
		selectFromDropdown(COMPANY_NAME_ELEMENT, company);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNo(9999) + email);
	}

	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandomNo(99));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}

	public void clickOnSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
	}

	public void verifyProfilePage() {
		
		waitForElement(driver, 5,SUMMARY_ON_PROFILE_ELEMENT );	

		Assert.assertEquals(SUMMARY_ON_PROFILE_ELEMENT.getText(), "Summary", "Wrong page!!!");

	}
	

	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[3]/td[3]
	// tbody/tr[i]/td[3]
	
	

	String beforeXpath = "//tbody/tr[";
	String afterXpath = "]/td[3]";
	String afterXpathDelete = "]/td[3]/following-sibling::td[4]/a[2]";

	public void verifyEnteredNameAndDelete() {

		for (int i = 1; i <= 10; i++) {
			String enteredName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			/*System.out.println(enteredName);
			Assert.assertEquals(enteredName, generatedName, "Entered Name does not exist!");*/
			
			if (enteredName.contains(generatedName)) {
				System.out.println("Entered name Exist!!");
				driver.findElement(By.xpath(beforeXpath + i + afterXpathDelete)).click();
			}
			break;
		}

	}
}
