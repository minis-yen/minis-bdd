package net.minis.bdd.sit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.minis.bdd.WebDriverFactory;
import net.minis.bdd.constants.Constants;

public class T001_LoginSystem implements Constants {

	private WebDriver driver = WebDriverFactory.getCurrentDriver();

	public T001_LoginSystem() {
		this.driver.manage().window();
	}

	@Given("^進入系統 > \"([^\"]*)\"$")
	public void 進入系統(String url) throws Throwable {
		driver.get(url);
		Thread.sleep(2000);
	}

	@When("^輸入使用者帳號: \"([^\"]*)\", 密碼: \"([^\"]*)\", 點選確定登入$")
	public void 輸入使用者帳號_密碼_點選確定登入(String username, String password) throws Throwable {

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
		Thread.sleep(500);
	}

	@Then("^確認是否進入主頁面$")
	public void 確認是否進入主頁面() throws Throwable {
		Thread.sleep(3000);
	}

	@When("^登出系統 > \"([^\"]*)\"$")
	public void 登出系統(String url) throws Throwable {
		driver.get(url);
		Thread.sleep(1000);
	}

	@Then("^離開系統$")
	public void 離開系統() throws Throwable {
		driver.quit();
	}

}
