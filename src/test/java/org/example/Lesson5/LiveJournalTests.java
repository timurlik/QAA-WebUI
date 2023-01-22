package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LiveJournalTests {

    WebDriver driver;
    ChromeOptions options;
    Actions builder;

    static final String URL = "https://www.livejournal.com/";
    static final String LOGIN = "TestUser1990";
    static final String PASSWORD = "TestUserPassword1990";
    static final String HEADER = "New Test Header";
    static final String TEXT = "New test text.";

    @BeforeAll
     static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setOptions () {
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @AfterEach
    void quit() {
        driver.quit();
    }

    @Test
    @Order(1)
    void logInTest() {
        driver.get(URL);

        WebElement signInButton = driver.findElement(By.xpath("//a[@href=\"https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1\"]"));
        signInButton.click();

        WebElement loginInputField = driver.findElement(By.xpath("//*[@id=\"user\"]"));
        loginInputField.sendKeys(LOGIN);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'lj_loginwidget_password']"));
        passwordInputField.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class = \"b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center\"]"));
        loginButton.click();

        WebElement userInfo = driver.findElement(By.xpath("//a[@title = 'testuser1990']"));
        Assertions.assertEquals("TESTUSER1990",userInfo.getText());

    }

    @Order(2)
    @Test
    void navLinkTest() {
        driver.get(URL);

        WebElement firstNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[1]"));
        firstNavElement.click();

        WebElement secondNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[2]"));
        secondNavElement.click();

        WebElement thirdNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[3]"));
        thirdNavElement.click();

        WebElement fourthNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[4]"));
        fourthNavElement.click();

        WebElement sixthNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[5]"));
        sixthNavElement.click();

        WebElement seventhNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[6]"));
        seventhNavElement.click();

        WebElement eighthNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[7]"));
        eighthNavElement.click();

        WebElement ninthNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[8]"));
        ninthNavElement.click();

        WebElement tenthNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[9]"));
        tenthNavElement.click();

        WebElement eleventhNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[10]"));
        eleventhNavElement.click();

        WebElement twelfthNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[11]"));
        twelfthNavElement.click();

        WebElement thirteenthNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[12]"));
        thirteenthNavElement.click();

        WebElement text = driver.findElement(By.xpath("//a[. = 'Развлечения']"));
        Assertions.assertNotNull(text);

    }

    @Order(3)
    @Test
    void newPostCreatingTest() {
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
        }
        Assertions.assertNotNull(driver.findElement(By.xpath("//span[text() = 'New Test Header']")));
    }

    @Order(4)
    @Test
    void existPostDeletingTest() throws InterruptedException {
        driver.get(URL);
        WebElement signInButton = driver.findElement(By.xpath("//a[@href=\"https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1\"]"));
        signInButton.click();

        WebElement loginInputField = driver.findElement(By.xpath("//*[@id=\"user\"]"));
        loginInputField.sendKeys(LOGIN);

        WebElement passwordInputField = driver.findElement(By.xpath("//input[@id = 'lj_loginwidget_password']"));
        passwordInputField.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class = \"b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center\"]"));
        loginButton.click();

        WebElement dropDown = driver.findElement(By.xpath("//a[@title = \"testuser1990\"]"));
        dropDown.click();

        builder = new Actions(driver);
        builder
                .moveByOffset(854, 339)
                .click(driver.findElement(By.xpath("//a[@title = \"Редактировать запись\"]//span[1]")))
                .perform();

        WebElement deletingPostButton = driver.findElement(By.xpath("//a[text() = \"Удалить пост\"]"));
        deletingPostButton.click();

        WebElement deletingPostButtonConf = driver.findElement(By.xpath("//span[text()='Удалить']"));
        deletingPostButtonConf.click();

        Assertions.assertNotNull(driver.findElement(By.xpath("//a[text()='Создать первую запись']")));
    }
}
