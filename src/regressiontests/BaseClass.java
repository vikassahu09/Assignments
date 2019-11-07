package regressiontests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static void main(String[] args) {

		// configuring and Setting path for chromedriver
		System.setProperty("webdriver.chrome.driver", "/Users/vikassahu/Desktop/chromedriver");
		// Launching the Chrome browser
		WebDriver driver = new ChromeDriver();
		// Maximizing the window
		driver.manage().window().maximize();
		// general implicit wait
		// driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);

		// nAvigating to required web page
		driver.navigate()
				.to("https://www.instafinancials.com/company/cbl-data-science-private-limited/U72501KA2016PTC092387");

		// Waiting for the pop-up to appear and click on "Later".
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' Later')]")));
		driver.findElement(By.xpath("//button[contains(text(),' Later')]")).click();

		// Creating object of script class
		RegressionScript obj = new RegressionScript(driver);

		// Array of companies name to which we want to navigate to. Any number can be
		// added.
		String[] companiesName = new String[] { "Infosys", "Amazon", "tech mahindra", "tcs", "flipkart", "google",
				"apple" };

		// Iterating the Array element and verifying the Head block for each element by
		// call the verifyHeadings() method.
		for (String s : companiesName) {
			obj.verifyHeadings(s);
		}

		driver.close();
	}

}
