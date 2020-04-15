package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert2 {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Max the browser
		driver.manage().window().maximize();
		// click the alert box
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		// switch to alert
		Alert alert = driver.switchTo().alert();
		// Close the alert
		alert.accept();
		// Click Confirm Box
		driver.findElementByXPath("//button[text()='Confirm Box']").click();
		// switch to alert
		Alert alert1 = driver.switchTo().alert();
		// Close the alert
		alert1.accept();
		// click the Prompt box
		driver.findElementByXPath("//button[text()='Prompt Box']").click();
		// switch to alert
		Alert alert2 = driver.switchTo().alert();
		// type something
		alert2.sendKeys("kan");
		// close the alert
		alert2.accept();
		// Click Sweet Alert
		driver.findElementByXPath("//button[text()='Sweet Alert']").click();
		driver.findElementByXPath("//button[text()='OK']").click();

	}

}
