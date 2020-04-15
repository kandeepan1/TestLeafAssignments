package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmentradiobutton {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get URL
		driver.get("http://www.leafground.com/home.html");
		// Click radio link
		driver.findElementByXPath("//img[@alt='Radio Button']").click();
		// Find how many Radio button
	    List<WebElement> radioButton = driver.findElementsByXPath("//input[@type='radio']");
	    System.out.println(radioButton.size());
				
		
	}
	

}
