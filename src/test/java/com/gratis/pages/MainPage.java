package com.gratis.pages;

import com.utils.BrowserUtils;
import com.utils.ConfigReader;
import com.utils.Driver;
import com.utils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends TestBase {

    public MainPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@class='nav-list']//*[text()='Cilt Bakım']")
    public WebElement ciltBakimi;


    public void goToMainPage() {
        Driver.get().get(ConfigReader.get("url"));

        BrowserUtils.waitForClickablility(ciltBakimi, 5);

       // ciltBakimi.click();
    }

    public void validateTitle(String title){

        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);

         Assert.assertEquals(title, actualTitle);

    }

}
