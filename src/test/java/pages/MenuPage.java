package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BrowserUtil;

public class MenuPage extends BrowserUtil{
	
	
	public MenuPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void navigateToMenu(String mainMenu, String subMenu) throws InterruptedException {
		System.out.println(mainMenu + " --> " + subMenu);
		////a[@class='dropdown-toggle'][contains(text(),'My Services')]
		getdriver().findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'" + mainMenu + "')]")).click();
		Thread.sleep(1000);
		getdriver().findElement(By.xpath("//a[contains(text(),'" + subMenu + "')]")).click();
		Thread.sleep(1000);
	
	}
	
	
	public void validateMenu() throws InterruptedException {
		String arrMainMenu [] = {"My Services", "Gateway"};
		String arrMyServices[] = {"All Services", "Activate Service", "Deactivate Service"};
		String arrGateway[] = {"OEM & TFA Pages", "OEM Job Activity"};
		
		for (int i=0 ; i< arrMainMenu.length; i++) {
			if (i==0)
				for(int j=0; j< arrMyServices.length; j++) {
					navigateToMenu(arrMainMenu[i], arrMyServices[j]);
					Thread.sleep(1000);
				}
			if(i==1)
				for(int j=0; j< arrMyServices.length; j++) {
					navigateToMenu(arrMainMenu[i], arrGateway[j]);
					Thread.sleep(1000);
				}
		}
		
	}

}
