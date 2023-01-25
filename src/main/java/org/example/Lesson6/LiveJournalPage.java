package org.example.Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LiveJournalPage {

    Actions builder;
    private WebDriver driver;
    private static final String URL = "https://www.livejournal.com/";
    private static final String SIGNINBUTTON= "//a[@href=\"https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1\"]";
    private static final String LOGINBUTTON = "//button[@class = \"b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center\"]";
    private static final String LOGININPUTFIELD = "//*[@id=\"user\"]";
    private static final String PASSWORDINPUTFIELD = "//input[@id = 'lj_loginwidget_password']";
    private static final String NAVLIST = "//ul[@class = \"categories__list js--limited-list\"]/li[position()<13]";
    private static final String POSTCREATINGBUTTON = "//span[contains(text(),\"Написать в блог\")]";
    private static final String POSTBUTTON  = "//*[text() = \"Опубликовать\"]";
    private static final String SETANDPOSTBUTTON = "//span[text()= \"Настроить и опубликовать\"]";
    private static final String HEADERINPUTAREA = "//textarea[@class = \"text-0-2-179\"]";
    private static final String PLACEHOLDERAREA = "//div[@class = \"DraftEditor-editorContainer\"]/div/div/div[2]/div";
    private static final String DROPDOWNBUTTON = "//a[@title = \"testuser1990\"]";
    private static final String MODIFYPOSTBUTTON = "//a[@title = \"Редактировать запись\"]//span[1]";
    private static final String DEALETINGPOSTBUTTON = "//a[text() = \"Удалить пост\"]";
    private static final String CONFIRMDELETINGBUTTON = "//span[text()='Удалить']";

    public LiveJournalPage(WebDriver driver) {
        this.driver = driver;
    }

    public LiveJournalPage getPage() {
        driver.get(URL);
        return this;
    }
    public LiveJournalPage logIn (String login, String password) {
        driver.findElement(By.xpath(SIGNINBUTTON)).click();
        driver.findElement(By.xpath(LOGININPUTFIELD)).sendKeys(login);
        driver.findElement(By.xpath(PASSWORDINPUTFIELD)).sendKeys(password);
        driver.findElement(By.xpath(LOGINBUTTON)).click();
        return this;
    }
    public void navLinkClick () {
        List<WebElement> navList = driver.findElements(By.xpath(NAVLIST));
        for(int i = 0; i < navList.size(); i++) {
            navList.get(i).click();
            i = i + 1;
            navList = driver.findElements(By.xpath(NAVLIST));
            i--;
         }
    }
    public void newPostCreating(String header, String text) {
        driver.findElement(By.xpath(POSTCREATINGBUTTON)).click();
        driver.findElement(By.xpath(HEADERINPUTAREA)).sendKeys(header);
        driver.findElement(By.xpath(PLACEHOLDERAREA)).sendKeys(text);
        driver.findElement(By.xpath(SETANDPOSTBUTTON)).click();
        driver.findElement(By.xpath(POSTBUTTON)).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void existPostDeleting() {
        driver.findElement(By.xpath(DROPDOWNBUTTON)).click();
        builder = new Actions(driver);
        builder
                .moveByOffset(854, 339)
                .click(driver.findElement(By.xpath(MODIFYPOSTBUTTON)))
                .perform();
        driver.findElement(By.xpath(DEALETINGPOSTBUTTON)).click();
        driver.findElement(By.xpath(CONFIRMDELETINGBUTTON)).click();
    }

}
