package net.minis.bdd.login.case001;

import net.minis.bdd.constants.Constants;
import net.minis.bdd.login.LoginFeature;

import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginTest implements Constants {

    LoginFeature login = new LoginFeature(new FirefoxDriver());

    @Given("Login system " + PARAMS_KEY + ", username: " + PARAMS_KEY + ", password: " + PARAMS_KEY)
    public void login(String url, String username, String password) throws Exception {
        login.doLogin(url, username, password);
    }

    @Then("Logout system " + PARAMS_KEY)
    public void logout(String url) throws Exception {
        login.doLogout(url);
    }

}
