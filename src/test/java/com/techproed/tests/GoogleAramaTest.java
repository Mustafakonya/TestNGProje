package com.techproed.tests;

import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleAramaTest extends TestBaseFinal {

    @Test
    public void aramaTesti() throws InterruptedException {

        extentTest = extentReports.createTest("Google Arama","Google'da techproeducation.com aramasi yaptik.");
        extentTest.info("sayfa adresine git");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));

        extentTest.info("webelementleri kullanabilmek icin nesne olustur.");
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();

        googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);

        Thread.sleep(3000);

        boolean linkVarMi = false;
        for (WebElement w : googleAramaPage.tumLinkler) {
            if (w.getText().contains("techproeducation123.com")){
                linkVarMi = true;
                break;
            }
        }
        Assert.assertTrue(linkVarMi);
        extentTest.pass("Testimiz PASSED");
    }

}
