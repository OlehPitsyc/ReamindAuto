package google.page;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
	private WebDriver driver;
	private static String baseUrl = "https://www.google.com.ua/";

	public StartPage openStartPage() {
		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToDriver);

		driver = new ChromeDriver();
		driver.get(baseUrl);
		return new StartPage(driver);
	}

	public void close() {
		if (this.driver != null);
		this.driver.quit();
		this.driver = null;

	}

}
