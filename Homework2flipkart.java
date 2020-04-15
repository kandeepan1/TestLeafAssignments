package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Homework2flipkart {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Max the browser
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElementByXPath("//button[@class='_2AkmmA _29YdH8']").click();
		Thread.sleep(5000);
		// Hover the cursor on Electronics
		WebElement eleC = driver.findElementByXPath("//span[text()='Electronics']");
		// Perform Actions
		Actions builder = new Actions(driver);
		builder.moveToElement(eleC).perform();
		Thread.sleep(5000);
		// Click on Mi
		driver.findElementByLinkText("Mi").click();
		// Title Name as : Mi Mobile
		String text = driver.findElementByXPath("//h1[text()='Mi Mobiles']").getText();
		System.out.println("Mobile Tile Name:"+text);

	}

}
