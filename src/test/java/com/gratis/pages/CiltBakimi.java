package com.gratis.pages;

import com.utils.BrowserUtils;
import com.utils.Driver;
import com.utils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CiltBakimi extends TestBase {

    public CiltBakimi() {
        PageFactory.initElements(Driver.get(), this);
    }

    String firstProduct;
    String secondProduct;

   // @FindBy(css = ".form-group.checkbox-structure")
    @FindBy(xpath = "//span[@data-bind='text: name']")
    public List<WebElement> checkBox;

    // //ul[@data-bind='foreach: visibleRefinements']//li
    @FindBy(xpath = "//ul[@data-bind='foreach: visibleRefinements']//span[@class='filter-value']")
    public List<WebElement> chosenCheckBoxes;


    public void chooseCheckBoxes(){

        BrowserUtils.waitFor(2);
        System.out.println("checkBox.size() = " + checkBox.size());

        Random rn = new Random();
        int firstRandomNumber = rn.nextInt(checkBox.size());
        System.out.println("firstRandomNumber = " + firstRandomNumber);

        BrowserUtils.waitFor(1);
        WebElement element = checkBox.get(firstRandomNumber);

        firstProduct = element.getText();

        System.out.println("Seçilen ilk ürün = " + firstProduct);
        element.click();

        BrowserUtils.waitFor(2);

        Random rn2 = new Random();
        int secondRandomNumber = rn2.nextInt(checkBox.size());

        while (firstRandomNumber == secondRandomNumber){
            secondRandomNumber = rn2.nextInt(checkBox.size());
        }
       // System.out.println("rn2 = " + secondRandomNumber);

        WebElement element2 = checkBox.get(secondRandomNumber);

        secondProduct = element2.getText();

        System.out.println("Seçilen ikinci ürün = " + secondProduct);

        element2.click();
    }

    public void validateCheckBoxes(){

        BrowserUtils.waitFor(5);

        BrowserUtils.waitForVisibility(chosenCheckBoxes.get(1),5);

        int size = chosenCheckBoxes.size();

        Assert.assertEquals(2, size);

        String expectedFirstProduct = chosenCheckBoxes.get(0).getText();
        String expectedSecondProduct = chosenCheckBoxes.get(1).getText();

        Assert.assertEquals(expectedFirstProduct,firstProduct);

        Assert.assertEquals(expectedSecondProduct,secondProduct);

    }

}
