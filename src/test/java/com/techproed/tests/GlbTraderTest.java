package com.techproed.tests;

import com.aventstack.extentreports.ExtentTest;
import com.techproed.pages.GlbTraderPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbTraderTest extends TestBaseFinal {

    @Test
    public void test1() throws InterruptedException {
        extentTest = extentReports.createTest("Glbtrader test", "glbtrader.com u test et");
        extentTest.info("glbtrader.com a gidiyoruz");
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_link"));

        extentTest.info("GlbtraderPage nesnesini olusturuyoruz");
        GlbTraderPage glbTraderPage = new GlbTraderPage();
        extentTest.info("Select class indan nesne olusturuyoruz");
        Select select = new Select(glbTraderPage.category);
        extentTest.info("dropdown dan Consumer Electronics i seciyoruz");
        select.selectByVisibleText("Consumer Electronics");

        extentTest.info("arama motoruna camera yazip aratiyoruz");
        glbTraderPage.searchbox.sendKeys(ConfigurationReader.getProperty("product") + Keys.ENTER);
        extentTest.info("3 saniye bekliyoruz");
        Thread.sleep(3000);

        extentTest.info("acilan sayfadaki urunlerin linklerini liste seklinde aliyoruz ve 2 numarali index teki urune tikliyoruz");
        String productName = glbTraderPage.list.get(2).getText();
        glbTraderPage.list.get(2).click();
        extentTest.info("2 saniye bekleyelim");
        Thread.sleep(2000);
        extentTest.info("sayfa title ini alalim");
        String title = Driver.getDriver().getTitle();

        Assert.assertEquals(productName, title);
        extentTest.pass("Test PASSED");



    }

}
