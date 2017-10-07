package opengoogle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import google.page.Google;
import google.page.ResultPage;
import google.page.StartPage;

public class SearchResultNumberTest {

	private WebDriver driver;
	private String baseUrl;

	private Google google = new Google();
	private StartPage startPage;
	private ResultPage resultPage;

	@BeforeClass
	public void setup() {
		startPage = google.openStartPage();
	}

	@Test
	public void testNumberOfSearchResult() {
		resultPage = startPage.searchFor("Hello Wolrd!");
		int actualNumber = resultPage.getSearchResultPage();
		Assert.assertEquals(actualNumber, 14);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();
	}

}
