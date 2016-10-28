package net.minis.bdd;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	private static WebDriver currentDriver;

	public static WebDriver getCurrentDriver() {
		if (currentDriver == null) {
			synchronized (WebDriverFactory.class) {
				if (currentDriver == null) {
					createDriver();
				}
			}
		}
		return currentDriver;
	}

	static void createDriver() {
		try {
			currentDriver = createChrome();
		} finally {
			Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
		}
	}

	static WebDriver createFireFox() {

		final File file = new File("./driver/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

		return new FirefoxDriver();
	}

	static WebDriver createChrome() {

		final File file = new File("./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");

		return new ChromeDriver(options);
	}

	static WebDriver createIE() {

		final File file = new File("./driver/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

		return new InternetExplorerDriver();
	}

	private static synchronized void close() {

		try {
			getCurrentDriver().quit();
		} catch (Throwable e) {
		}

		currentDriver = null;
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			close();
		}
	}

}
