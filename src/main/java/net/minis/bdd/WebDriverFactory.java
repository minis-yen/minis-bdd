package net.minis.bdd;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class WebDriverFactory {

	private static WebDriver currentDriver;

	public static WebDriver getCurrentDriver() {
		if (currentDriver == null) {
			try {
				currentDriver = createChrome();
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}
		}
		return currentDriver;
	}

	public static WebDriver createFireFox() {

		final File file = new File("./driver/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

		return new FirefoxDriver();
	}

	public static WebDriver createChrome() {

		final File file = new File("./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");

		return new ChromeDriver(options);
	}

	public static WebDriver createIE() {

		final File file = new File("./driver/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

		return new InternetExplorerDriver();
	}

	public static void close() {
		try {
			getCurrentDriver().quit();
			currentDriver = null;
		} catch (UnreachableBrowserException e) {
		}
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			close();
		}
	}

}
