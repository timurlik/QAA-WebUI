package org.example.Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LiveJournalTests {

    LiveJournalPage liveJournalPage;
    ChromeOptions options;
    WebDriver driver;
    private static final String LOGIN = "TestUser1990";
    private static final String PASSWORD = "TestUserPassword1990";
    private static final String HEADER = "New Test Header";
    private static final String TEXT = "New test text.";

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
        liveJournalPage = new LiveJournalPage(driver);
        liveJournalPage.getPage();
    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    @Order(1)
    @Test
    void logInTest() {
        liveJournalPage
                .logIn(LOGIN, PASSWORD);
        Assertions.assertEquals("TestUser1990", LOGIN);
    }

    @Order(2)
    @Test
    void navLinkClickTest() {
        liveJournalPage
                .navLinkClick();
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[. = 'Развлечения']")));
    }

    @Order(3)
    @Test
    void newPostCreatingTest() {
        liveJournalPage
                .logIn(LOGIN, PASSWORD)
                .newPostCreating(HEADER, TEXT);
        Assertions.assertNotNull(driver.findElement(By.xpath("//span[text() = 'New Test Header']")));
    }

    @Order(4)
    @Test
    void existPostDeleting() {
        liveJournalPage
                .logIn(LOGIN, PASSWORD)
                .existPostDeleting();
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[text()='Создать первую запись']")));
    }
}
