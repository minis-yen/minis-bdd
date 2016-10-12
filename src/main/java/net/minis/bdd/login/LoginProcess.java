package net.minis.bdd.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lombok.Data;

@Data
public class LoginProcess {

	public String baseUrl;

	protected WebDriver driver;

	public LoginProcess(WebDriver driver) {
		this.driver = driver;
		init();
	}

	public void init() {
		driver.manage().window();
	}

	public void doLogin(String url) throws Exception {
		Thread.sleep(3000);
	}

	public void doLogin(String url, String username, String password) throws Exception {

		driver.get(url);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
	}

	public void doLogout(String url) throws Exception {
		driver.get(url);
	}

	public void close() {
		driver.close();
		driver.quit();
	}

}
