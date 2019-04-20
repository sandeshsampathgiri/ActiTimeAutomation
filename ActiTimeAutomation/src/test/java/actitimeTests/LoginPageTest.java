package actitimeTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class LoginPageTest extends BaseClass {

	@BeforeMethod
	public void setUp() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.actitime.com");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyPageTitle() {
		String expectedPageTitle = "actiTIME - Login";
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expectedPageTitle);
	}

}
