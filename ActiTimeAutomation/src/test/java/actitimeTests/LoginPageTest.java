package actitimeTests;

import java.util.concurrent.TimeUnit;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;
import utilities.BaseClass;

public class LoginPageTest extends BaseClass {

	LoginPageObject lpo;
	LoginPageTest lpt;

	@BeforeMethod
	public void setUp() {
		lpt = new LoginPageTest();
		lpo = new LoginPageObject(driver);
		lpt.openChromeBrowser();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void verifyPageTitle() {
		String expectedPageTitle = "actiTIME - Login";
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expectedPageTitle);
	}

	@Test
	public void verifyAdminLogin() throws InterruptedException {

		By username_locator = By.xpath("//input[@name='username']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(username_locator));

		lpo.findUsername(driver).sendKeys("admin");
		lpo.findPassword(driver).sendKeys("manager");
		lpo.clickLoginBtn(driver).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement logoutLink = wait1.until(ExpectedConditions.presenceOfElementLocated(lpo.logoutLnk));

		boolean status = logoutLink.isDisplayed();
		Assert.assertEquals(status, true);
	}

}
