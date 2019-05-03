package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {

	public static WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public static By username = By.xpath("//input[@name='username']");
	public static By password = By.xpath("//input[@name='pwd']");
	public static By loginBtn = By.xpath("(//div[contains(text(),'Login')])[1]");
	public static By logoutLnk = By.xpath("//a[contains(text(),'Logout')]");
	public static By exploreActiTime_locator = By.xpath("//span[@class='Start exploring actiTIME']");
	public static By enterTimeTrack = By.xpath("//td[contains(text(),'Enter Time-Track')]");
	public static By invalidCredentials = By.xpath("//span[contains(text(),'Username or Password is invalid')]");

	public WebElement findUsername(WebDriver driver) {
		System.out.println("Driver=" + driver);
		return driver.findElement(username);
	}

	public WebElement findPassword(WebDriver driver) {
		return driver.findElement(password);

	}

	public WebElement clickLoginBtn(WebDriver driver) {
		return driver.findElement(loginBtn);

	}

	public WebElement clickExploreActiTimeBtn(WebDriver driver) {
		return driver.findElement(exploreActiTime_locator);

	}

	public WebElement verifyenterTimeTrackTxt(WebDriver driver) {
		return driver.findElement(enterTimeTrack);
	}
	
	public WebElement verifyValidationMsgWithInvalidCredentials(WebDriver driver)
	{
		return driver.findElement(invalidCredentials);
	}

	
	 public WebElement verifyLogoutBtn(WebDriver driver) { 
		 return  driver.findElement(logoutLnk); 
	 }
	 

}
