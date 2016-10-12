package net.minis.bdd.sit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.minis.bdd.WebDriverFactory;
import net.minis.bdd.constants.Constants;
import net.minis.bdd.login.LoginProcess;

public class T001_LoginSystem implements Constants {

    LoginProcess login = new LoginProcess(WebDriverFactory.create());
  
    @Given("Login > " + PARAMS_KEY + ", username: " + PARAMS_KEY + ", password: " + PARAMS_KEY)
    public void login(String url, String username, String password) throws Exception {
        login.doLogin(url, username, password);
    }

    @When("^Change to LogIn Page$")
    public void navigateLogInPage() throws Throwable {
    }

    @When("^Enters Username and Password$")
    public void enterUsernameAndPassword() throws Throwable {
    }

    @Then("Logout > " + PARAMS_KEY)
    public void logout(String url) throws Exception {
        login.doLogout(url);
        login.close();
    }

}
