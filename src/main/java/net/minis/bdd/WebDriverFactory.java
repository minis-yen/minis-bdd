package net.minis.bdd;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	public static WebDriver create() {
		return createFireFox();
	}

	public static WebDriver createFireFox() {

		final File file = new File("D:/Selenium/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

		return new FirefoxDriver();
	}

	public static WebDriver createChrome() {

		final File file = new File("D:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");

		return new ChromeDriver(options);
	}

	public static WebDriver createIE() {

		final File file = new File("D:/Selenium/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

		return new InternetExplorerDriver();
	}

}
