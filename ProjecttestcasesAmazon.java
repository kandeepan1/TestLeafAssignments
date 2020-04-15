package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ProjecttestcasesAmazon {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get URL
		driver.get("https://www.amazon.com/");
		// enter books in search
        driver.findElementById("twotabsearchtextbox").sendKeys("books");
        // click Search
        driver.findElementByXPath("//input[@type='submit']").click();
        // click the 1st book
	    driver.findElementByXPath("(//span[@class='a-truncate-cut'])[1]").click();
	    //  get 1st author name
	    String author1 = driver.findElementByLinkText("Jason Reynolds").getText();
	    System.out.println("author name1:"+author1);
	    // get 2nd author name
	    String author2 = driver.findElementByLinkText("Ibram X. Kendi").getText();
	    System.out.println("author name2:"+author2);
	    // get price of the book
	    String price = driver.findElementByXPath("//span[text()[normalize-space()='$9.99']]").getText();
	    System.out.println("price of the book:"+price);
	}

}
