package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {

    //http:/www.fhctrip-qa.com/admin/HotelAdmin/Create
    //Username: manager2
    //Password: Man1ager2!

    @BeforeMethod
    public void girisTest(){
        driver.get("http:/www.fhctrip-qa.com/admin/HotelAdmin/Create");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void hotelCreate(){
        driver.findElement(By.id("Code")).sendKeys("12341838");
        driver.findElement(By.id("Name")).sendKeys("Mustafa");
        driver.findElement(By.id("Address")).sendKeys("Chemin des Bosquets");
        driver.findElement(By.id("Phone")).sendKeys("077345562234");
        driver.findElement(By.id("Email")).sendKeys("asd@gmail.com");

        WebElement dropDown = driver.findElement(By.id("IDGroup"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.id("btnSubmit")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(element.isDisplayed());


    }
}
