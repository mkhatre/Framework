package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.BrowserUtil;
import util.ConfigReader;

public class MyPages extends BrowserUtil {
	
	public MyPages() { 
		
		PageFactory.initElements(getdriver(), this); 
		System.out.println ("--------- Initialize Page Factory -----------"); 
	 }
	
	@FindBy(how=How.XPATH, using = "//*[@id='username']")  
	private static WebElement input_gw_username ;
	
	@FindBy(how=How.ID, using = "password")
	private static WebElement input_gw_password ;
	
	@FindBy(how=How.ID, using = "signin_bttn")
	private static WebElement btn_gw_signin;

	public void gwPortalLogin() {
		try {
			ConfigReader config = new ConfigReader();
			System.out.println(config.getAppUrl());
			System.out.println ("--------- Inside gwPortalLogin -----------");
			
			getdriver().get(config.getAppUrl());
			Thread.sleep(5000);
			
			input_gw_username.sendKeys(config.getUserName());
			input_gw_password.sendKeys(config.getPassword());
			btn_gw_signin.click();
			Thread.sleep(5000);
			
			WebDriverWait wait = new WebDriverWait(getdriver(), 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title']")));
			System.out.println("--- My Services title visible ----");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Platinum")));
			System.out.println("--- Platinum Service visible ----");
		}
		catch(Exception e) {
			System.out.println ("Exception :"+ e);
		}
		
		
	}

}
