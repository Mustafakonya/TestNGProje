package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbTraderPage {

    public GlbTraderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@class='form-control typeahead top_bar_search tt-query']")
    public WebElement searchbox;

    @FindBy(xpath = "//select[@name='header_search_category']")
    public WebElement category;

    @FindBy(xpath = "//h4/a")
    public List<WebElement> list;

}
