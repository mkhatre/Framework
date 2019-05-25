package action;


import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.*;
import util.BrowserUtil;


public class MyAction extends BrowserUtil{
		
	@Given("^Initial Steps$")
	public void initial_steps() throws Throwable{
		LauchBrowser();
	}
	
	@Given("^GW Portal Login$")
	public void gw_Portal_Login() throws Throwable {
		MyPages mypages = new MyPages();
		mypages.gwPortalLogin();
	}
	
	@When("^Validate Menus$")
	public void validate_Menus() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		MenuPage menupages = new MenuPage();
		menupages.validateMenu();		
		
	}
	
	@After
	public void closebrowser(){
		close_browser();
		
	}

}

