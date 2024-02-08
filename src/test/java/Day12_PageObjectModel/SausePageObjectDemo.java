package Day12_PageObjectModel;

import Pages.SauseDemoLoginPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class SausePageObjectDemo {
public static void main(String[] args) throws InterruptedException {
	
	sauceLoginDemo();
	
}
	public static void sauceLoginDemo() throws InterruptedException {
		SauseDemoLoginPage loginPage = new SauseDemoLoginPage();
		BrowserUtils utils= new BrowserUtils();
		Driver.getDriver().get(DataReader.getProperty("sause_url"));
		utils.waitForElementToBeVisible(loginPage.loginUserName);
		//highlight element with JS executer
		utils.highlightElement(loginPage.loginUserName);
		//type username
		loginPage.loginUserName.sendKeys(DataReader.getProperty("sauce_username"));
		//type password
		loginPage.loginpassword.sendKeys(DataReader.getProperty("sauce_password"));
		//click on bttn
		loginPage.loginBTTN.click();
		
		//Driver.quitDriver();
		
	}
}
