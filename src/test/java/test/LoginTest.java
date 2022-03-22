package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("testData\\TF_TestData2.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	
@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();		
		
		
	LoginPage login = PageFactory.initElements(driver, LoginPage.class ); 	
		login.insertUserName("userName");	
		login.insertPassword("password");
		login.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboard();
		BrowserFactory.tearDown();
	}
	
}
