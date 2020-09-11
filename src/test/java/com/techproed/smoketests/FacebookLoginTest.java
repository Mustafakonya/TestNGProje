package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FacebookLoginTest extends TestBase {

    @Test
    public void girisTesti(){
        driver.get("http:/facebook.com");

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("fb_email"));
        facebookLoginPage.sifreKutusu.sendKeys(ConfigurationReader.getProperty("fb_pass"));

    }

}
