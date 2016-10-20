package net.minis.bdd.sit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.minis.bdd.WebDriverFactory;
import net.minis.bdd.constants.Constants;
import net.minis.bdd.login.LoginProcess;

public class T001_LoginSystem implements Constants {

	LoginProcess loginProcess = new LoginProcess(WebDriverFactory.getCurrentDriver());

	@Given("^進入系統 > \"([^\"]*)\" 登入頁面$")
	public void 進入系統_登入頁面(String url) throws Throwable {
		loginProcess.doEnterPage(url);
	}

	@When("^輸入使用者帳號: \"([^\"]*)\", 密碼: \"([^\"]*)\", 點選確定登入$")
	public void 輸入使用者帳號_密碼_點選確定登入(String username, String password) throws Throwable {
		loginProcess.doLogin(username, password);
	}

	@Then("^系統登入後將進入主頁面$")
	public void 系統登入後將進入主頁面() throws Throwable {
	}

	@Then("^登出系統 > \"([^\"]*)\"$")
	public void 登出系統(String url) throws Throwable {
		loginProcess.doLogout(url);
		loginProcess.close();
	}

}
