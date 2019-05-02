package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	public static WebDriver driver;
	public static ChromeOptions options;

	public void captureScreenshot(String methodName) throws IOException {
		String screenshotPath = System.getProperty("user.dir");

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,
				new File(screenshotPath + "\\executionScreenshots\\" + methodName + "_Screenshot.png"));
	}

	public void openChromeBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//resources//chromedriver.exe");
		options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		// options.addArguments("start-maximized");
		options.setAcceptInsecureCerts(true);

		driver = new ChromeDriver(options);
		driver.get("https://demo.actitime.com");
	}

}
