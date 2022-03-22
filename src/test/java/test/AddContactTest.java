package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("testData\\TF_TestData2.xlsx");
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String company = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlread.getCellData("AddContactInfo", "Email", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);	
	String state = exlread.getCellData("AddContactInfo", "State", 2);	
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	
@Test

public void valisUserShouldBeAbleToAddCustomers() {
	
	driver = BrowserFactory.init();
	
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	login.insertUserName("demo@techfios.com");
	login.insertPassword("abc123");
	login.clickSigninButton();
	
	DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
	dashboard.verifyDashboard();
	dashboard.clickCustomerButton();
	dashboard.clickAddCustomerButton();
	
	AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
	addContactPage.insertFullName(fullName);
	addContactPage.selectCompany(company);
	addContactPage.insertEmail(email);
	addContactPage.insertPhone(phone);
	addContactPage.insertAddress(address);
	addContactPage.insertCity(city);
	addContactPage.insertState(state);
	addContactPage.insertZip(zip);
	addContactPage.selectCountry(country);
	addContactPage.clickOnSubmitButton();
	
	addContactPage.verifyProfilePage();
	
	dashboard.clickListCustomerButton();
	addContactPage.verifyEnteredNameAndDelete();
	
	
	
	
	
}
}

