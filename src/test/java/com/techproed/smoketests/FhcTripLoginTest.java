package com.techproed.smoketests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {

    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("fhc_login"));
        FhcTripLoginPage fhcTripLoginPage = new FhcTripLoginPage(driver);
        fhcTripLoginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
        fhcTripLoginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        fhcTripLoginPage.logIn.click();
    }
}
