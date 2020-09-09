package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import java.util.List;

public class WebTableTest extends TestBase {

    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void table(){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement baslik : basliklar) {
            System.out.println(baslik.getText());
        }

    }
    @Test
    public void tumSatirlar(){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement satir : tumSatirlar) {
            System.out.println(satir.getText());
        }
    }

    @Test
    public void tumElemanlar(){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement elemanlar : elements) {
            System.out.println(elemanlar.getText());
        }
    }

    @Test
    public void sutun(){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> elements = driver.findElements(By.xpath("//tbody//td[4]"));
        for (WebElement elemanlar : elements) {
            System.out.println(elemanlar.getText());
        }
    }

    @Test
    public void calistir(){
        noktaAtisi(3,5);
    }

    public void noktaAtisi(int satir, int sutun){
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String xpathDegerim = "//tbody/tr[" + satir + "]/td[" + sutun + "]";

        WebElement element = driver.findElement(By.xpath(xpathDegerim));
        System.out.println(element.getText());
    }

}
