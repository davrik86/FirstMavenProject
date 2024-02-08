package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SauseDemoLoginPage {

	// how do we create a page class
	// 1. We need a class for a page of the application
	// 2. We need to create constructor with page factory of selenium
	// then collect the web element
	
	public SauseDemoLoginPage() {//default constructor
		PageFactory.initElements(Driver.getDriver(), this);
	}
	//what this line for, is PageFactory initialize all the elements in this class with the driver instance, whenever 
	//an object of this class is created
	
	
	
	
	//how do we collect web element
	@FindBy (id="user-name")
	public WebElement loginUserName;
	
	@FindBy (id="password")
	public WebElement loginpassword;
	
	@FindBy (xpath ="//input[@id='login-button']")
	public WebElement loginBTTN;
	
	@FindBy (css="h3[data-test='error']")
	public WebElement errorEmptyError;
	
	
	
}
