package net.minis.bdd.login;

import lombok.Getter;
import lombok.Setter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFeature {

    @Getter
    @Setter
    public String baseUrl;

    @Getter
    @Setter
    protected WebDriver driver;

    public LoginFeature(WebDriver driver) {
        this.driver = driver;
    }

    public void init() {
        driver.manage().window();
    }

    public void doLogin(String url, String username, String password) throws Exception {

        driver.get(url);

        driver.findElement(By.id("acUser")).clear();
        driver.findElement(By.id("password")).clear();

        driver.findElement(By.id("acUser")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("loginBtn")).click();
        Thread.sleep(3000);
    }

    public void doLogout(String url) throws Exception {
        driver.get(url);
    }

}
