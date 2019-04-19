package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	public static WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='pwd']");
	By loginBtn = By.xpath("(//div[contains(text(),'Login')])[1]");

	public WebElement findUsername() {
		return driver.findElement(username);
	}

	public WebElement findPassword() {
		return driver.findElement(password);

	}

	public WebElement clickLoginBtn() {
		System.out.println("Driver under LoginPageObject="+driver);
		return driver.findElement(loginBtn);
		
	}

}
