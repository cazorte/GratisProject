package com.gratis.pages;

import com.utils.BrowserUtils;
import com.utils.Driver;
import com.utils.ExcelUtil;
import com.utils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBox extends TestBase {

    public LoginBox() {
        PageFactory.initElements(Driver.get(), this);
    }

    // //section[@class='log-section']//*[.='Giriş Yap']
    @FindBy(xpath = "//section[@class='log-section']//*[.='Giriş Yap']")
    public WebElement loginBoxText;

    @FindBy(xpath = "//input[@data-bind='validatableValue: login']")
    public WebElement username;

    @FindBy(xpath = "//input[@data-bind='validatableValue: password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='login-register-modal']/div/div/div[1]/button")
    public WebElement closeX;

    public void validateLoginPage() {

        String actualText = BrowserUtils.waitForVisibility(loginBoxText,10).getText();

        String expectedText = "Giriş Yap";

        Assert.assertEquals(expectedText,actualText);


    }

    public void textToUsername(String str){
        BrowserUtils.waitForClickablility(username,10);
        username.click();
        username.sendKeys(str);
        BrowserUtils.waitFor(2);
    }

    public void textToPassword(String str){
        password.click();
        password.sendKeys(str);
        BrowserUtils.waitFor(2);
    }

    public String[] readExcelFile(){
        ExcelUtil exc = new ExcelUtil("src/test/Resources/prod.xlsx", "Sheet1");

        String[][] dataArray = exc.getDataArray();
        String[] rowArray = new String[exc.columnCount()];

        for (int i = 0; i < rowArray.length; i++) {
            rowArray[i] = dataArray[0][i].trim();
        }
        return rowArray;
    }

    public void closeBox(){

        BrowserUtils.waitForVisibility(closeX,10);
        closeX.click();

    }


}
