package day10th;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayHomeWork {
 public static void main(String[]args) {
	 
	 ebayHowerOverCarTrucks(); 
	// ebayHowerOverElectronics();
 }
 public static void ebayHowerOverElectronics() {
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	 
	 driver.get("https://ebay.com");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electronics")));
	 
	 WebElement electronics= driver.findElement(By.linkText("Electronics"));
	 Actions act= new Actions(driver);
	 
	 act.moveToElement(electronics).build().perform(); 
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Car & Truck Parts")));
	 WebElement cameraPhotos= driver.findElement(By.linkText("Cameras & Photo"));
	 act.moveToElement(cameraPhotos).click().perform();
	 String page="Cameras & Photo";
	 System.out.println("Vryfy the page is "+ page + " "+ driver.getTitle().contains(page) );
	 driver.quit();
 }
 public static void ebayHowerOverCarTrucks() {
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	 
	 driver.get("https://ebay.com");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Motors")));
	 
	 WebElement motors= driver.findElement(By.linkText("Motors"));
	 Actions act= new Actions(driver);
	 
	 act.moveToElement(motors).build().perform(); 
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Car & Truck Parts")));
	 WebElement carsTrucks= driver.findElement(By.linkText("Car & Truck Parts"));
	 act.moveToElement(carsTrucks).click().perform();
	 String page="Car & Truck Parts & Accessories";
	 System.out.println("Vryfy the page is "+ page + " "+ driver.getTitle().contains(page) );
	 driver.quit();
 }
}
