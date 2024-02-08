package Day9th;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrameDemo {
public static void main(String[] args) {
	
	iFrameDemo();
	
}
public static void nestedIframe() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.get("https://demoqa.com/frames");
	
	driver.switchTo().parentFrame(); //drivers goes back to parent frame
	driver.switchTo().defaultContent();//driver goes to the default frame
	
}

public static void iFrameDemo() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.get("https://demoqa.com/frames");
	driver.switchTo().frame("frame1");
	
	String mainFrame= driver.findElement(By.xpath("//iframe[@id=\"frame1\"]")).getText();
	System.out.println(mainFrame); 
	if(mainFrame.equals("This is a sample page ")) {
		System.out.println(" we are in the frame");
		
	}else {
		System.out.println("we are not in iFrame");
	}
	
	driver.switchTo().defaultContent();
	String mainFrameText2= driver.findElement(By.xpath("//iframe[@id=\"frame1\"]")).getText();
	System.out.println(mainFrameText2);
	
}

}
