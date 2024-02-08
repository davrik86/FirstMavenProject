package Day9th;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class nestedIframe {
public static void main(String[] args) {
	WebDriver driver= new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.get("https://demoqa.com/nestedframes");
	// find default content 
	String content= driver.findElement(By.xpath("(//div[@id='framesWrapper']//div)[1]")).getText();
	
	//switch to parent frame storing the text and printing it
	driver.switchTo().frame("frame1");
	String parentText =driver.findElement(By.xpath("/html/body")).getText();
	System.out.println(parentText);
	//switching to the child frame xpath
	driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));
	String chieldText=driver.findElement(By.xpath("/html/body/p")).getText();
	System.out.println(chieldText);
	//switching to default 
	driver.switchTo().defaultContent();
	//gathering iframe text and storing it again
	String parentDefText =driver.findElement(By.xpath("/html/body")).getText();
	System.out.println("This is with default switch beein used "+parentDefText);
	// comparing initial gathered co1ntent with after making few switches
	System.out.println("Initial content text matches with the later one :"+ parentDefText.contains(content));
	driver.quit();
}
}
