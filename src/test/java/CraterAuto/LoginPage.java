package CraterAuto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
public static void main(String[] args) {
	
	craterLogin();
	
	
}

public static void craterLogin() {
	
	WebDriver driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	
	driver.get("http://crater.primetech-apps.com/login");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
//	driver.findElement(By.name("email")).sendKeys("dummy@primetechschool.com"+ Keys.ENTER);
	Actions act= new Actions(driver);
	act.sendKeys("dummy@primetechschool.com");
	WebElement email=driver.findElement(By.xpath("//input[1]"));
	WebElement pass=driver.findElement(By.xpath("//input[@name=\"password\"]"));
	act.sendKeys(email, "dummy@primetechschool.com").build().perform();
	act.sendKeys(pass, "primetech@school").build().perform();
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	
}
}
