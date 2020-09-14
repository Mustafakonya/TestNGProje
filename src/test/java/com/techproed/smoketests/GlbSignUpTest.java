package com.techproed.smoketests;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class GlbSignUpTest {

    @Test
    public void test(){
       Driver.getDriver().get(ConfigurationReader.getProperty("glb_url"));

        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
        glbSignUpPage.nameKutusu.sendKeys(ConfigurationReader.getProperty("glb_name"));
        glbSignUpPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("glb_email"));
        glbSignUpPage.mobileKutusu.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        glbSignUpPage.passwordKutusu.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        glbSignUpPage.rePasswordKutusu.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        glbSignUpPage.signUpButonu.click();
        System.out.println(glbSignUpPage.basariliYazisi.getText());
        Assert.assertTrue(glbSignUpPage.basariliYazisi.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}
