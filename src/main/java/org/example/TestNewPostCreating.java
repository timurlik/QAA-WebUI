package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestNewPostCreating {

    private static final String URL = "https://www.livejournal.com/";
    private static final String LOGIN = "TestUser1990";
    private static final String PASSWORD = "TestUserPassword1990";
    private static final String HEADER = "New Test Header";
    private static final String TEXT = "New test text.";


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

        WebElement makingPostButton = driver.findElement(By.xpath("//span[contains(text(),\"Написать в блог\")]"));
        makingPostButton.click();

        WebElement headerInputArea = driver.findElement(By.xpath("//textarea[@class = \"text-0-2-179\"]"));
        headerInputArea.sendKeys(HEADER);

        WebElement placeHolderArea = driver.findElement(By.xpath("//div[@class = \"DraftEditor-editorContainer\"]/div/div/div[2]/div"));
        placeHolderArea.click();
        placeHolderArea.sendKeys(TEXT);

        WebElement setAndPostButton = driver.findElement(By.xpath("//span[text()= \"Настроить и опубликовать\"]"));
        setAndPostButton.click();

        WebElement postButton = driver.findElement(By.xpath("//*[text() = \"Опубликовать\"]"));
        postButton.click();

        try {
            Thread.sleep(10000);
        }   catch (InterruptedException e) {
            e.printStackTrace();
        }   finally {
            driver.quit();
        }
    }
}