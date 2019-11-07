package regressiontests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * We can put all the xpaths at one place weather in a Java Class or some external files like spreadsheet/properties file.
 * Same applied with URLs and chromedriver server.
 * we can use pageFactory and testNG to put all this in a framework and prepare a xml file(test suite) to trigger our test cases.
 */

public class RegressionScript {
	ExpectedCondition<Boolean> expectation;
	WebDriver driver;

	// Constructor
	public RegressionScript(WebDriver driver) {
		this.driver = driver;
	}

	// method for waiting for the page to load
	public void waitForPageLoaded() {
		expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(expectation);
	}

	// Method for verifying whether all the Head blocks are present in UI or not.
	public void verifyHeadings(String companyName) {

		// Enter company name in search box
		driver.findElement(By.id("txt-search")).sendKeys(companyName);

		// Waiting for the auto-suggest list to appear
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='search-results']/li[1]")));
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Not able to load the auto suggest list");
		}
		// Selecting the first webElement from the auto-suggest list
		driver.findElement(By.xpath("//ul[@id='search-results']/li[1]")).click();

		// Waiting for "bouncing ball and requesting server" page to disappear
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(
					ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='requesting server...']]")));
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Stuck on bouncing ball and requesting server page");
		}

		// Waiting for the page to load
		waitForPageLoaded();

		// Verifying the presence of head blocks for current company

		System.out.println("Heading status for " + companyName + " are :- ");

		boolean isCompanyOverviewDisplayed = driver.findElement(By.xpath("//h2[contains(text(),'Company Overview')]"))
				.isDisplayed();
		if (isCompanyOverviewDisplayed) {
			System.out.println("Company overview is diplayed");
		} else {
			System.out.println("BUG!! Company overview is not diplayed");
		}

		boolean isCompanyHighlightsDisplayed = driver.findElement(By.xpath("//h2[text()='Company Highlights']"))
				.isDisplayed();
		if (isCompanyHighlightsDisplayed) {
			System.out.println("Company Highlights is diplayed");
		} else {
			System.out.println("BUG!! Company Highlights is not diplayed");
		}

		boolean isKYCInfomationDisplayed = driver.findElement(By.xpath("//h2[text()='KYC Infomation']")).isDisplayed();
		if (isKYCInfomationDisplayed) {
			System.out.println("KYC Infomation is diplayed");
		} else {
			System.out.println("BUG!! KYC Infomation is not diplayed");
		}

		boolean isIndustryClassificationDisplayed = driver
				.findElement(By.xpath("//h2[text()='Industry Classification']")).isDisplayed();
		if (isIndustryClassificationDisplayed) {
			System.out.println("Industry Classificationn is diplayed");
		} else {
			System.out.println("BUG!! Industry Classification is not diplayed");
		}

		boolean isCreditRatingsDisplayed = driver
				.findElement(By.xpath("//h2[text() = 'Credit Ratings ( available for last 24 months)']")).isDisplayed();
		if (isCreditRatingsDisplayed) {
			System.out.println("Credit Ratings is diplayed");
		} else {
			System.out.println("BUG!! Credit Ratings is not diplayed");
		}

		boolean isDirectorsDetailDisplayed = driver.findElement(By.xpath("//h2[text()= 'Directors Detail']"))
				.isDisplayed();
		if (isDirectorsDetailDisplayed) {
			System.out.println("Directors Detail is diplayed");
		} else {
			System.out.println("BUG!! Directors Detail is not diplayed");
		}

		boolean isSignatoriesDetailsDisplayed = driver.findElement(By.xpath("//h2[text()= 'Signatories Details']"))
				.isDisplayed();
		if (isSignatoriesDetailsDisplayed) {
			System.out.println("Signatories Detailsl is diplayed");
		} else {
			System.out.println("BUG!! Signatories Details is not diplayed");
		}

		boolean isPastDirectorsAndPastSignatoriesDisplayed = driver
				.findElement(By.xpath("//h2[text()= 'Past Directors / Past Signatories']")).isDisplayed();
		if (isPastDirectorsAndPastSignatoriesDisplayed) {
			System.out.println("Past Directors / Past Signatories is diplayed");
		} else {
			System.out.println("BUG!! Past Directors / Past Signatories is not diplayed");
		}

		boolean isPotentialRelatedPartyDisplayed = driver
				.findElement(By.xpath("//h2[text()= 'Potential Related Party']")).isDisplayed();
		if (isPotentialRelatedPartyDisplayed) {
			System.out.println("Potential Related Party is diplayed");
		} else {
			System.out.println("BUG!! Potential Related Party is not diplayed");
		}

		boolean isOpenChargesAndBorrowingsDisplayed = driver
				.findElement(By.xpath("//h2[text()= 'Open Charges / Borrowings']")).isDisplayed();
		if (isOpenChargesAndBorrowingsDisplayed) {
			System.out.println("Open Charges / Borrowings is diplayed");
		} else {
			System.out.println("BUG!! Open Charges / Borrowings is not diplayed");
		}

		boolean isLocationsDisplayed = driver.findElement(By.xpath("//h2[text()= 'Locations']")).isDisplayed();
		if (isLocationsDisplayed) {
			System.out.println("Locations is diplayed");
		} else {
			System.out.println("BUG!! Locations is not diplayed");
		}

		boolean isEmploymentTrendDisplayed = driver.findElement(By.xpath("//div[@id='epfoHeader']//h2[1]"))
				.isDisplayed();
		if (isEmploymentTrendDisplayed) {
			System.out.println("Employment Trend is diplayed");
		} else {
			System.out.println("BUG!! Employment Trend is not diplayed");
		}

		boolean isDirectorsInfoAndOtherDirectorshipsDisplayed = driver
				.findElement(By.xpath("//div[@id='OthDirHeader']//h2[1]")).isDisplayed();
		if (isDirectorsInfoAndOtherDirectorshipsDisplayed) {
			System.out.println("Directors Info and Other Directorships is diplayed");
		} else {
			System.out.println("BUG!! Directors Info and Other Directorships is not diplayed");
		}

		System.out.println("--------------------------------------------------");

	}

}
