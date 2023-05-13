package com.gratis.pages;

import com.utils.BrowserUtils;
import com.utils.Driver;
import com.utils.ExcelUtil;
import com.utils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends TestBase {

    public ProductPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h1[@data-bind='text: displayName']")
    public WebElement productName;

    @FindBy(xpath = "//g-price[@class='pdp-price pdp-price-main']//span[@class='gr-price__amount']")
    public WebElement productPrice;

    // //ul[@class='product-options']//*[.='SEPETE EKLE']
    @FindBy(xpath = "//ul[@class='product-options']//*[.='SEPETE EKLE']")
    public WebElement addBasket;

    public void textToExcelColumn(String name, int column){

        BrowserUtils.waitForVisibility(productName,10);
        BrowserUtils.waitForVisibility(productPrice,10);

        System.out.println("productName.getText() = " + productName.getText());

        System.out.println("productPrice.getText() = " + productPrice.getText());

        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/SearchKeywords.xlsx", "Sheet1");

        if (name.equals("ürün bilgisi")){

           // excelUtil.setCellData("asd",2,5);

        }else if (name.equals("ürün tutarı")){
          //  excelUtil.setCellData("qwe",3,6);

        }
    }

    public void addToBasket(){

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,750)");
        BrowserUtils.waitForClickablility(addBasket,10);
        addBasket.click();


    }


}
