package Day11;

import org.openqa.selenium.By;

import utils.DataReader;
import utils.Driver;

public class DriverUtilDemo {
public static void main(String[] args) {
	
	SauseDemo();
	
}
public static void SauseDemo() {
	Driver.getDriver().get("https://saucedemo.com");
	Driver.getDriver().findElement(By.id("user-name")).sendKeys(DataReader.getProperty("sauce_usernam"));
	Driver.getDriver().findElement(By.id("password")).sendKeys(DataReader.getProperty("sauce_password"));
	Driver.getDriver().findElement(By.id("login-button")).click();
	
}
}
