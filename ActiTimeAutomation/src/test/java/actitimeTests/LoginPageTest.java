package actitimeTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPageObject;
import utilities.BaseClass;

public class LoginPageTest extends BaseClass {

	LoginPageObject lpo;
	LoginPageTest lpt;
	SoftAssert softAssert;

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

		// By username_locator = By.xpath("//input[@name='username']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(lpo.username));

		lpo.findUsername(driver).sendKeys("admin");
		lpo.findPassword(driver).sendKeys("manager");
		lpo.clickLoginBtn(driver).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement logoutLink = wait1.until(ExpectedConditions.presenceOfElementLocated(lpo.logoutLnk));

		boolean status = logoutLink.isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Test
	public void verifyTraineeLoginTest() {
		// By username_locator = By.xpath("//input[@name='username']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(lpo.username));

		lpo.findUsername(driver).sendKeys("trainee");
		lpo.findPassword(driver).sendKeys("trainee");
		lpo.clickLoginBtn(driver).click();

		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.presenceOfElementLocated(lpo.enterTimeTrack));
		boolean loginStatus = lpo.verifyenterTimeTrackTxt(driver).isDisplayed();
		Assert.assertEquals(loginStatus, true);

	}

	@Test
	public void verifyValidationMsgWithInvalidLoginTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(lpo.username));

		lpo.findUsername(driver).sendKeys("sandesh");
		lpo.findPassword(driver).sendKeys("sandesh");
		lpo.clickLoginBtn(driver).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(lpo.invalidCredentials));

	}

	@Test
	public void verifyValidationMsgWithoutUsernameTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(lpo.username));

		// lpo.findUsername(driver).sendKeys("sandesh");
		lpo.findPassword(driver).sendKeys("sandesh");
		lpo.clickLoginBtn(driver).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(lpo.invalidCredentials));

	}

	@Test
	public void verifyValidationMsgWithoutPasswordTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(lpo.username));

		lpo.findUsername(driver).sendKeys("sandesh");
		// lpo.findPassword(driver).sendKeys("sandesh");
		lpo.clickLoginBtn(driver).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(lpo.invalidCredentials));

	}

	@Test
	public void verifyValidationMsgWithoutCredentialsTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(lpo.username));

		// lpo.findUsername(driver).sendKeys("sandesh");
		// lpo.findPassword(driver).sendKeys("sandesh");
		lpo.clickLoginBtn(driver).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(lpo.invalidCredentials));

	}

	@Test
	public void verifyLogoutTest() {

		softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(lpo.username));

		lpo.findUsername(driver).sendKeys("admin");
		lpo.findPassword(driver).sendKeys("manager");
		lpo.clickLoginBtn(driver).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(lpo.logoutLnk));
		String expectedHomePageTitle = "actiTIME - Enter Time-Track";
		String actualHomePageTitle = driver.getTitle();
		softAssert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
		lpo.verifyLogoutBtn(driver).click();

		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.presenceOfElementLocated(lpo.username));
		String expectedLoginPageTitle = "actiTIME - Login";
		String actualLoginPageTitle = driver.getTitle();
		softAssert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);

		softAssert.assertAll();

	}
}
