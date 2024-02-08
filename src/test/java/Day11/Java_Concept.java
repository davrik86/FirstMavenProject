package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Java_Concept {
public static void main(String[] args) {
	
	
	concatStrings("hello","world");
}
public static String getText(WebElement x) {
	return x.getText();
}
public static void sendMsg(WebElement elemnt, String message ) {
	elemnt.sendKeys(message);
	
}
public static void  clickonit(WebElement x) {
	x.click();
}

public static String concatStrings( String name, String name2) {
	return name.concat(name2);
	 
}
}
