package day_8th;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandleingDemo {
public static void main(String[] args) throws InterruptedException {
	
	//alertexam();
	//alertwithDelay();
	//confrimAct();
	promtAlert();
}
public static void promtAlert() throws InterruptedException {
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	driver.get("https://demoqa.com/alerts");
	driver.findElement(By.xpath("//button[@id=\"promtButton\"]")).click();
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.alertIsPresent());
	
	Alert handle= driver.switchTo().alert();
	String message= "PrimeTech";
	handle.sendKeys(message+ Keys.ENTER);
	handle.accept();
	String promMSG = driver.findElement(By.xpath("//span[@id=\"promptResult\"]")).getText();
	if(promMSG.equalsIgnoreCase("You entered "+ message)) {
		System.out.println("PASS:Entered message matches ");
	}else{
		System.out.println("FAILD:actual message is: "+promMSG);
	}
	
	
}


public static void confrimAct() {
	
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	
	driver.get("https://demoqa.com/alerts");
	driver.findElement(By.xpath("//button[@id=\"confirmButton\"]")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.alertIsPresent());
	
	Alert handle= driver.switchTo().alert();
	String alertTXT =handle.getText();
	
	if(alertTXT.equals("Do you confirm action?")) {
		System.out.println("Alert message matches");
	}else {
		System.out.println("Alert message matches does not matches");
	}
	handle.dismiss();
	String finalTxt= driver.findElement(By.xpath("//span[@id=\"confirmResult\"]")).getText();
	if(finalTxt.equals("You selected Cancel")) {
		System.out.println("Final Alert message matches");
	}else {
		System.out.println("Final Alert message matches does not matches");
	}
}

public static void alertwithDelay() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	driver.get("https://demoqa.com/alerts");
		
	driver.findElement(By.xpath("//button[@id=\"timerAlertButton\"]")).click();
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.alertIsPresent());
	
	Alert handle= driver.switchTo().alert();
	String alert= handle.getText();
	if (alert.equals("This alert appeared after 5 seconds")) {
		System.out.println("Pass");
	}else {
		System.out.println("Faild");
	}
	handle.accept();
}

public static void alertexam() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	driver.get("https://demoqa.com/alerts");
	driver.findElement(By.xpath("//button[@id='alertButton']\"]")).click();
	//lets wait until Alert pops up
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.alertIsPresent());
	Alert letHandle = driver.switchTo().alert();
	letHandle.accept();
}
}
