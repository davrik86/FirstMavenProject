package day10th;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class ActionCkassDemo {
public static void main(String[] args) {
	
	actionHowerOver();
	//dragAndDrop();
}
public static void dragAndDrop() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.get("https://demoqa.com/droppable");
	Actions act = new Actions(driver);
	
	WebElement dragMeBox= driver.findElement(By.id("draggable"));
	WebElement dragHereBox = driver.findElement(By.id("droppable"));
	
	act.dragAndDrop(dragMeBox,dragHereBox).build().perform();
	
	
	
}


public static void actionHowerOver() {
	
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	driver.get("https://demoqa.com/menu");
	Actions act = new Actions(driver);
	WebElement menuItem2= driver.findElement(By.linkText("Main Item 2"));
	act.moveToElement(menuItem2).build().perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SUB SUB LIST »")));
	WebElement subSubList = driver.findElement(By.linkText("SUB SUB LIST »"));
	
	act.moveToElement(subSubList).build().perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sub Sub Item 1")));
	WebElement subSUbItem1= driver.findElement(By.linkText("Sub Sub Item 1"));
	
	act.moveToElement(subSUbItem1).build().perform();
	
	
			
}

}
