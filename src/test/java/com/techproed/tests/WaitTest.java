package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {

    @Test
    public void implicitlyWait(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement remove = driver.findElement(By.xpath("//*[.='Remove']"));
        remove.click();
        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));
        Assert.assertTrue(element.isDisplayed());

    }

    @Test
    public void explicitlyWait(){
        driver.get("http:/the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement remove = driver.findElement(By.xpath("//*[.='Remove']"));
        remove.click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(element.getText());



    }
}
