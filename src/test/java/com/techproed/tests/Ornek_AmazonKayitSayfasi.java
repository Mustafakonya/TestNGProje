package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {
    //DAY 14

    @Test
    public void test01(){
        driver.get("http:/amazon.com");
        WebElement hello = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hello).perform();

        WebElement start = driver.findElement(By.partialLinkText("Start here"));
        start.click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Amazon Registration");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02(){
        driver.get("http:/amazon.com");
        WebElement hello = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hello).perform();

        WebElement start = driver.findElement(By.partialLinkText("Start here"));
        start.click();
        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Mustafa");
        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("muskon33@gmail.com");
        WebElement sifre = driver.findElement(By.id("ap_password"));
        sifre.sendKeys("konmus33.");
        WebElement sifre2 = driver.findElement(By.id("ap_password_check"));
        sifre2.sendKeys("konmus33.");
        WebElement onay = driver.findElement(By.id("continue"));
        onay.click();


    }

}
