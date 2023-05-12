package com.gratis.pages;

import com.utils.BrowserUtils;
import com.utils.ConfigReader;
import com.utils.Driver;
import com.utils.TestBase;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainPage extends TestBase {

    public MainPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@class='nav-list']//*[text()='Cilt Bakım']")
    public WebElement ciltBakimi;

    @FindBy(xpath = "//li[@class='active']//a[@class='mm-head-navs wo-icon']")
    public List<WebElement> altBaslik;

    //#icon-close-button-1606209896503
    @FindBy(css = "#icon-close-button-1606209896503")
    public WebElement close;

    ////div[@class='form-group checkbox-structure']//input[@type='checkbox']
    //.form-group.checkbox-structure
    //@FindBy(xpath = "//div[@class='form-group checkbox-structure']//input[@type='checkbox']")
    @FindBy(css = ".form-group.checkbox-structure")
    public List<WebElement> checkBox;


    public void goToMainPage() {
        Driver.get().get(ConfigReader.get("url"));
    }

    public void validateTitle(String title){

        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);

         Assert.assertEquals(title, actualTitle);
    }

    public void mouseHover(WebElement buton){

        BrowserUtils.waitForClickablility(buton, 5);

        Actions action = new Actions(driver);

        action.moveToElement(buton).perform();

    }

    public void clickSubContentRandom_Validate(){

        BrowserUtils.waitFor(4);

        try {
            //Store the web element
            WebElement element = driver.findElement(By.cssSelector(".sp-fancybox-iframe.sp-fancybox-skin.sp-fancybox-iframe-5388"));
            BrowserUtils.waitForVisibility(element, 5);
            WebElement iframe = driver.findElement(By.cssSelector(".sp-fancybox-iframe.sp-fancybox-skin.sp-fancybox-iframe-5388"));

            //Switch to the frame
            driver.switchTo().frame(iframe);

            //Now we can click the button
            driver.findElement(By.cssSelector(".fa.fa-times.element-close-button")).click();

            driver.switchTo().defaultContent();
        }
        catch(Exception e) {
        e.printStackTrace();
        }

        System.out.println("altBaslik.size() = " + altBaslik.size());

        Random rn = new Random();
        int a = rn.nextInt(altBaslik.size()-1);
        BrowserUtils.waitFor(1);
        WebElement element = altBaslik.get(a);
        System.out.println("element.getText() = " + element.getText());
        String text = element.getText().split(" ")[0].toLowerCase();
        String textEnglish = StringUtils.stripAccents(text);
        System.out.println("textEnglish = " + textEnglish);

        BrowserUtils.waitForClickablility(element,5);
        element.click();
        BrowserUtils.waitFor(3);
        String actualResult = Driver.get().getCurrentUrl();
        System.out.println("actualResult = " + actualResult);

        Assert.assertTrue(actualResult.contains(textEnglish));

    }

    public void chooseCheckBoxes(){

        BrowserUtils.waitFor(2);
        System.out.println("checkBox.size() = " + checkBox.size());

        Random rn = new Random();
        int firstRandomNumber = rn.nextInt(checkBox.size());
        System.out.println("firstRandomNumber = " + firstRandomNumber);

        BrowserUtils.waitFor(1);
        WebElement element = checkBox.get(firstRandomNumber);
        element.click();

        BrowserUtils.waitFor(2);

        Random rn2 = new Random();
        int secondRandomNumber = rn2.nextInt(checkBox.size());

        while (firstRandomNumber == secondRandomNumber){
            secondRandomNumber = rn2.nextInt(checkBox.size());
        }
        System.out.println("rn2 = " + secondRandomNumber);

        WebElement element2 = checkBox.get(secondRandomNumber);

        element2.click();









    }


}
