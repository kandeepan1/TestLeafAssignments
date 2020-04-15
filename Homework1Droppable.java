package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Homework1Droppable {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("http://www.leafground.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Max the browser
		driver.manage().window().maximize();
		// Click Droppable
		driver.findElementByLinkText("Droppable").click();
		Thread.sleep(5000);
		// Perform Drag
		WebElement drag = driver.findElementById("draggable");
		// Perform Drop
		WebElement drop = driver.findElementById("droppable");
		// Perform Actions
		Actions builder = new Actions(driver);
		builder.dragAndDrop(drag, drop).perform();

	}

}
