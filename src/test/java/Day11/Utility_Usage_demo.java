package Day11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtils;

public class Utility_Usage_demo {
	public static void main(String[] args) {
		AlertUtilDemo();
	}
public static void AlertUtilDemo() {
	BrowserUtils utils= new BrowserUtils();
	WebDriver driver =new ChromeDriver();
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.get("https://demoqa.com/alerts");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	WebElement bttn= driver.findElement(By.id("alertButton"));
	bttn.click();
	wait.until(ExpectedConditions.alertIsPresent());
	
	utils.acceptAlert(driver);
	
}
}
