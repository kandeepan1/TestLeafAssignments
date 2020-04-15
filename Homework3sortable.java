package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Homework3sortable {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("http://www.leafground.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Max the browser
		driver.manage().window().maximize();
		// Click on sortable
		driver.findElementByXPath("//img[@alt='sortable']").click();
		// find the 1st item
		WebElement item1 = driver.findElementByXPath("//li[text()[normalize-space()='Item 1']]");
		// Perform Actions
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, 0, 124).perform();
		
	}

}
