package day_8th;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class deselect {
public static void main(String[] args) throws InterruptedException {
	
//	demoDeselect();
//	demomultyDeselect();
	
	webDriverWaitDemo();
	
}

public static void 	webDriverWaitDemo() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	driver.get("https://ebay.com");
	
	driver.findElement(By.linkText("Motors")).click();
	WebDriverWait letsWait= new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement addVich=driver.findElement(By.xpath("//div[text()='Add a vehicle']"));
	letsWait.until(ExpectedConditions.visibilityOf(addVich));
	letsWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[text()='Add a vehicle']"))));
	System.out.println("Element is visible");
	driver.quit();
	
}

public static void demomultyDeselect() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	driver.get("https://demoqa.com/select-menu");
	
	WebElement multiCarSelect= driver.findElement(By.xpath("//select[@name='cars']"));
	Select select= new Select(multiCarSelect);
	select.selectByVisibleText("Volvo");
	select.selectByVisibleText("Saab");
	select.selectByVisibleText("Opel");
	select.selectByVisibleText("Audi");
	Thread.sleep(2000);
	
	//deselect the value
	
	select.deselectByVisibleText("Saab");
	
	
			
	
}


public static void demoDeselect() throws InterruptedException {
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	driver.get("https://demoqa.com/select-menu");
	
	driver.findElement(By.xpath("//div[text()='Select...']")).click();
	
	driver.findElement(By.xpath("//div[text()='Green']")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//div[text()='Blue']")).click();
	
	driver.findElement(By.xpath("//div[text()='Black']")).click();
	
	//remove green 
	driver.findElement(By.xpath("//div[@class='css-xb97g8'][1]")).click();
}
}
