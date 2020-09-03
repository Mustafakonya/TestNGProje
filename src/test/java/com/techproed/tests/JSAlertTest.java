package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void JsAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        driver.switchTo().alert().accept();

    }

    @Test
    public void jsConfirmTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement ikincibutton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        ikincibutton.click();
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void jsPrompTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //<button onclick="jsPrompt()">Click for JS Prompt</button>
        WebElement ucuncubutton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        ucuncubutton.click();
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        driver.switchTo().alert().sendKeys("Merhaba Selenium");
        driver.switchTo().alert().accept();
    }
}
