package util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtil {

	public static WebDriver driver;
	public static ConfigReader config;
	
	public static WebDriver getdriver() {
		return driver;
	}
	
	
	
	public static void LauchBrowser () throws InterruptedException {
		config = new ConfigReader();
		System.out.println("^"+ config.getBrowser() + "$");
		if(config.getBrowser().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\My Work\\Selenium\\chromedriver_win32_74\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(driver);
		}
		if(config.getBrowser().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
		}
	}
	
	public static void WaitForElementVisible(WebElement element) {
		
	}
	
	public static void close_browser() {
		if(getdriver() != null)
			driver.quit();
	}

}
