package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmentcheckbox {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get URL
		driver.get("http://www.leafground.com/home.html");
		// Click Check box
		driver.findElementByXPath("//img[@alt='Checkbox']").click();
		// check all the checkbox 
		List<WebElement> checkBoxs = driver.findElementsByXPath("//input[@type='checkbox']");
		for(WebElement select:checkBoxs) {
			if(!select.isSelected()) {
				select.click();
			}
		}

	}

}

