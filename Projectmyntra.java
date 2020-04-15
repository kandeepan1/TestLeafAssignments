package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Projectmyntra {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Max the browser
		driver.manage().window().maximize();
		// Mouse over actions
		Actions builder = new Actions(driver);
		// Mouse Over on Women
		WebElement women = driver.findElementByXPath("(//a[@class='desktop-main'])[2]");
		builder.moveToElement(women).perform();
		// Click Jackets & Coats
		driver.findElementByLinkText("Jackets & Coats").click();
		// Find the total count of item
		String text = driver.findElementByClassName("title-count").getText();
		String count = text.replaceAll("\\D", "");
		System.out.println("Total of Items Count:"+Integer.parseInt(count));
		int totalItems = Integer.parseInt(count);
		// Categories of Jackets Count
		String text2 = driver.findElementByClassName("categories-num").getText();
		String count1 = text2.replaceAll("\\D", "");
		System.out.println("Categories of Jackets Count:"+Integer.parseInt(count1));
		int totalJack = Integer.parseInt(count1);
		// Categories of Coats Count
		String text3 = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String count2 = text3.replaceAll("\\D", "");
		System.out.println("Categories of Coats Count:"+Integer.parseInt(count2));
		int totalCoat = Integer.parseInt(count2);
		// Sum of the total Categories
		if(totalItems == (totalJack + totalCoat )) {
			System.out.println("Sum of categories match");
		}	
		// Check Coats
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		// Click + more option under BRAND
		driver.findElementByXPath("//div[text()='58']").click();
		// Type MANGO in checkbox
		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("MANGO");
		// Click MANGO
		driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div[1]").click();
		// Close the pop up 'X'
		driver.findElementByXPath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]").click();
		Thread.sleep(3000);
		// Confirm all the Coats are of brand MANGO
		List<WebElement> brandM = driver.findElementsByXPath("//h3[@class='product-brand']");
		for(WebElement each : brandM) {
			String brand = each.getText();
			if(brand.equals("MANGO")) {
				System.out.println("the coats are of same brand as 'MANGO'");
			}
		}
		// sort by better Discount
		driver.findElementByXPath("//span[text()='Recommended']/following-sibling::span").click();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		Thread.sleep(3000);
		// find the price of first displayed item
		List<WebElement> priceF = driver.findElementsByXPath("(//span[@class='product-discountedPrice'])[1]");
		String fitemp = priceF.get(0).getText();
		System.out.println("price of 1st item displayed:"+fitemp);
		Thread.sleep(3000);	
		// mouse over on first item
		WebElement mouse = driver.findElementByXPath("//img[@alt='MANGO Women Orange Solid Double-Breasted Longline Overcoat']");
		builder.moveToElement(mouse).perform();
		// Click on Wishlist now
		driver.findElementByXPath("(//span[text()='wishlist now'])[1]").click();
		// Close Browser
		driver.close();

	}
}

