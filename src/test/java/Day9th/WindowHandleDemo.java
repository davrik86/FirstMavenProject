package Day9th;

import java.time.Duration;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WindowHandleDemo {
public static void main(String[] args) {
	
	//demoQAWindowhandle() ;
	
	demoQAWindowhandleloop();
	
}

public static void demoQAWindowhandleloop() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	driver.get("https://demoqa.com/browser-windows");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
	
	String mainWindID=driver.getWindowHandle();
	System.out.println("main Window ID is : "  +mainWindID);
	
	driver.findElement(By.id("tabButton")).click();
	
	
	//switch the windows
	Set<String> windowsIDs= driver.getWindowHandles();
	
	Iterator<String> iterate= windowsIDs.iterator();
	String firstWinID=iterate.next();// at this stage iterator is in next step;
	//after this code its on 1st step
	String secondWinID=iterate.next();// this is second item
	
	System.out.println("is there a nex item "+ iterate.hashCode() );
	
	driver.switchTo().window(secondWinID);
	
	
	//confirming that driver has switched to another tab
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sampleHeading")));
	if(driver.findElement(By.id("sampleHeading")).getText().equals("This is a sample page")){
		
		System.out.println("Pass Second window text matches");
	}else {
		System.out.println("FAILD Second window text does not match");
	}
	//closing the tab 
	//driver.close();
	//switching to main window
	driver.switchTo().window(mainWindID);
	System.out.println(driver.findElement(By.id("tabButton")));
	
}


public static void demoQAWindowhandle() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	driver.get("https://demoqa.com/browser-windows");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
	//how to find the unique ID for window ID
	
	String mainWindID=driver.getWindowHandle();
	System.out.println("main Window ID is : "  +mainWindID);
	
	driver.findElement(By.id("tabButton")).click();
	
	
	//switch the windows
	Set<String> windowsIDs= driver.getWindowHandles();
	for (String winID : windowsIDs) {
		if (!winID.equals(windowsIDs)) {
			driver.switchTo().window(winID);
		}
	}
	//confirming that driver has switched to another tab
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sampleHeading")));
	if(driver.findElement(By.id("sampleHeading")).getText().equals("This is a sample page")){
		
		System.out.println("Pass Second window text matches");
	}else {
		System.out.println("FAILD Second window text does not match");
	}
	//closing the tab 
	//driver.close();
	//switching to main window
	driver.switchTo().window(mainWindID);
	System.out.println(driver.findElement(By.id("tabButton")));
	
}


}
