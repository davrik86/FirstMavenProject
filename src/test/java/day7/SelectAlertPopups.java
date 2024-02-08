package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAlertPopups {	
public static void main(String[] args) throws InterruptedException {
	
	selectDemo();
	//choseOptionFromSelect();
	
}

	public static void selectDemo() throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://amazon.com");
		Thread.sleep(5000);
		String title="Amazon.com";
		System.out.println("curent title is Amazon.com: "+ driver.getTitle().contains(title));
		//select Clothing, Shoes & Jewelry
		WebElement department= driver.findElement(By.xpath("//select[@id]"));
		
		//select by visible text
		
		Select letsSelect= new Select(department);// sintax is the like creating new Object and 
//		letsSelect.selectByVisibleText("Clothing, Shoes & Jewelry");
//		Thread.sleep(500);
//		
//		
//		//by index
//		letsSelect.selectByIndex(5);
//		Thread.sleep(500);
//		
//		//by value attribute
//		letsSelect.selectByValue("search-alias=audible");
	
		//get 1st selected option from drop down
		String firststSelOpt = letsSelect.getFirstSelectedOption().getText();
		System.out.println("1st default selected item : "+firststSelOpt);
		
		// get all the selected opitons
		
		List<WebElement> allOptions =letsSelect.getOptions();
		int count=58;
		System.out.println(" The number of avalible options 58: "+ (allOptions.size()==(count)));
		
		String defDep="All Departments";
		String acctualValue= letsSelect.getFirstSelectedOption().getText();
		System.out.println("dropdown value is by default \"All Departments\" "+acctualValue.equals(defDep)+" "+acctualValue);
		
		letsSelect.selectByVisibleText("Home & Kitchen");
		driver.findElement(By.xpath("//input[@placeholder]")).sendKeys("coffee mug"+Keys.ENTER);
		String coffeMug= "coffee mug";
		System.out.println("you are on coffee mug search results page: "+driver.getTitle());
		Thread.sleep(500);
		
		
//		WebElement newDep = driver.findElement(By.xpath("//select[@id="searchDropdownBox"]"));
//					
//		Select letsSelect1= new Select(newDep);
		
//		
//		String expectedDep="Home & Kitchen";
//		String actualDep = letsSelect1.getFirstSelectedOption().getText();
//		System.out.println(actualDep);
//		System.out.println("verify you are in Home & Kitchen department " +actualDep.equals(expectedDep));
//		
//		for (int i=0; i<allOptions.size();i++ ) {
//			
//			System.out.println("the list of the items : "+allOptions.get(i).getText());
//		}
//		
//		
//		driver.quit();
		
	}

public static void choseOptionFromSelect() throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(500);
		//chose Algeria from country lsit
		
		driver.findElement(By.xpath("(//div[@class=\"ui fluid search selection dropdown\"])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='Algeria'])[1]")).click();
}
			
}
