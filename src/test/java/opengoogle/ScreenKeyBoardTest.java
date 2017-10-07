package opengoogle;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenKeyBoardTest {
	private WebDriver driver;
	private String baseUrl;
	WebElement keyboard;

	@BeforeClass
	public void setup() {
		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToDriver);

		baseUrl = "https://www.google.com.ua/";

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void testKeyBoardAppearance() {
		driver.get(baseUrl);
		driver.findElement(By.cssSelector(".gsst_a")).click();
		keyboard = driver.findElement(By.cssSelector("#kbd"));
		Assert.assertTrue(keyboard.isDisplayed());
	}

	@Test(priority = 2)
	public void testKeyBoarClosed() {
		WebElement keyboardClosedButton = keyboard.findElement(By.cssSelector(".vk-t-btn.vk-sf-cl"));
		keyboardClosedButton.click();
		Assert.assertFalse(keyboard.isDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}
