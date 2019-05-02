package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	public static WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public static By username = By.xpath("//input[@name='username']");
	public static By password = By.xpath("//input[@name='pwd']");
	public static By loginBtn = By.xpath("(//div[contains(text(),'Login')])[1]");
	public static By logoutLnk = By.id("logoutLink");

	public WebElement findUsername(WebDriver driver) {
		System.out.println("Driver="+driver);
		return driver.findElement(username);
	}

	public WebElement findPassword(WebDriver driver) {
		return driver.findElement(password);

	}

	public WebElement clickLoginBtn(WebDriver driver) {
		return driver.findElement(loginBtn);

	}
	
	/*
	 * public WebElement verifyLogoutBtn(WebDriver driver) { return
	 * driver.findElement(logoutLnk); }
	 */

}
