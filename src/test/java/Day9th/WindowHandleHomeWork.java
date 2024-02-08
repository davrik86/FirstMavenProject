package Day9th;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WindowHandleHomeWork {
public static void main(String[] args) {
	
	//demoQAWindowhandleloop();
	 winSwith();
	
}


public static void winSwith() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	WebDriverWait wait= new  WebDriverWait(driver, Duration.ofSeconds(5));
	
	driver.get("http://demo.guru99.com/popup.php");
	String title= driver.getTitle();
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '\"Click Here'\")]")));
	driver.findElement(By.linkText("Click Here")).click();
	// Finding the address and setting to the Set
	Set<String> windowsID=driver.getWindowHandles();
	Iterator<String> winID= windowsID.iterator();
	String firstWin= winID.next();
	String secondWin= winID.next();
	
	
	driver.switchTo().window(secondWin);
	driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("test@gmail.com" +Keys.ENTER);

//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Access details']")))
	//String tablePath="/html/body/table";
	
	WebElement table= driver.findElement(By.xpath("/html/body/table"));
//	System.out.println(item.getText());	

	String text= "This access is valid only for 20 days.";
	WebElement userId = driver.findElement(By.xpath("((/html/body/table/tbody)//tr//td)[3]"));
	// //td[text()='User ID:']//following-sibling::td
	WebElement userPass= driver.findElement(By.xpath("((/html/body/table/tbody)//tr//td)[5]"));
	// //td[text()='Password :']//following-sibling::td
	WebElement sign= driver.findElement(By.xpath("((/html/body/table/tbody)//tr//td)[6]"));
	System.out.println("User id : "+ userId.getText());
	System.out.println("User Pass : "+ userPass.getText());
	System.out.println(text+" does match expected result: " +text.equals(sign.getText()));
	String reTitle= driver.switchTo().window(firstWin).getTitle();
	System.out.println("Titles are matching : "+ reTitle.equals(title));
	
	driver.quit();
	
	
	}
	

	
	
	
	
	
	


public static void demoQAWindowhandleloop() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	driver.get("https://demoqa.com/browser-windows");
	String mainTitle= driver.getTitle();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
	//getting the main window ID & print
	String mainWinID= driver.getWindowHandle();	
	System.out.println(" Main Window ID" +mainWinID);
	//find and click on newWindow button
	
	driver.findElement(By.id("windowButton")).click();
	
	//store window ID to a Set and use iterator to iterate trough the ID's
	Set<String> windowID= driver.getWindowHandles();
	Iterator<String> iterator= windowID.iterator();
	String firstWinID = iterator.next();
	String SecondWinID = iterator.next();
	
	//verify that firstWinID equals to mainWinID
	if (mainWinID.equals(firstWinID)) {
		System.out.println("Pass ID matches");
	}else {
		System.out.println("Failed ID's doe not match");
	}
	
	//Switch to new window
	driver.switchTo().window(SecondWinID);
	String textToMatch= driver.findElement(By.id("sampleHeading")).getText();
	// verify that text in Window does match
	if (textToMatch.equals("This is a sample page")) {
		System.out.println("Pass the text does  match");
	}else {
		System.out.println("Failed the text does not match");
	}
	//close 2nd window
	driver.close();
	driver.switchTo().window(mainWinID);
	//veryfy that you are in the main window
	
	System.out.println("You are in the main window: "+ driver.getTitle().equals(mainTitle));
	
	
	
	
	
}
}
