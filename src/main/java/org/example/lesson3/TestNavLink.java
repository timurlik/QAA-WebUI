package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestNavLink {

    private static final String URL = "https://www.livejournal.com/";

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(URL);

        //Здесь было бы правильнее поместить элементы в ArrayList, но у меня, после открытия первого элемента,
        //пробрасывало исключение, Stale Element Reference Exception, тест падал.
        //Час мучиля, и решил искать элементы по одному.
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

        WebElement thirteenthNavElement = driver.findElement(By.xpath("//ul[@class = \"categories__list js--limited-list\"]/li[11]"));
        thirteenthNavElement.click();

        driver.quit();
    }
}
