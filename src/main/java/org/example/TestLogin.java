package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestLogin {

    private static final String URL = "https://www.livejournal.com/";
    private static final String LOGIN = "TestUser1990";
    private static final String PASSWORD = "TestUserPassword1990";

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(URL);

        WebElement signInButton = driver.findElement(By.xpath("//a[@href=\"https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1\"]"));
        signInButton.click();

        WebElement loginInputField = driver.findElement(By.xpath("//*[@id=\"user\"]"));
        loginInputField.sendKeys(LOGIN);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'lj_loginwidget_password']"));
        passwordInputField.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class = \"b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center\"]"));
        loginButton.click();

        try{
            driver.findElement(By.xpath("//span[contains(text(),\"testuser1990\")] "));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
