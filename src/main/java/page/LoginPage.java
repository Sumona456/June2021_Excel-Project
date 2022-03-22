package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage() {

	}

	public LoginPage(WebDriver driver) {
this.driver = driver;
	}

	// methods/variable/attribute/field
	// Login data
	String userName = "demo@techfios.com";
	String password = "abc123";

	By userNameField = By.xpath("//input[@id='username']");
	By passWordField = By.xpath("//*[@id=\"password\"]");
	By signInButtonField = By.xpath("/html/body/div/div/div/form/div[3]/button");

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
	WebElement SIGN_IN_BUTTON;

	// individual method
	public void insertUserName(String userName) {

		USERNAME_ELEMENT.sendKeys(userName);
	}

	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}

	public void clickSigninButton() {
		SIGN_IN_BUTTON.click();
	}
	// Together method

	public void performloginTest(String userName, String password) {
		USERNAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGN_IN_BUTTON.click();
	}

}
