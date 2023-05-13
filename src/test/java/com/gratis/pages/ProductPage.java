package com.gratis.pages;

import com.utils.BrowserUtils;
import com.utils.Driver;
import com.utils.ExcelUtil;
import com.utils.TestBase;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

    public void textToExcelColumn(String name, int column) throws IOException {

        BrowserUtils.waitForVisibility(productName, 10);
        BrowserUtils.waitForVisibility(productPrice, 10);

        String productNameText = productName.getText();
        System.out.println("productNameText = " + productNameText);

        String productPriceText = productPrice.getText();
        System.out.println("productPriceText = " + productPriceText);

        // ExcelUtil excelUtil = new ExcelUtil("src/test/resources/prod.xlsx", "Sheet1");
        String filePath = "src/test/resources/prod.xlsx";

        XSSFWorkbook workbook;
        XSSFSheet sheet;

        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");

        if (name.equals("ürün bilgisi")) {

            // excelUtil.setCellData(productNameText,1,column);
            XSSFCell productCell = sheet.getRow(0).createCell(column);
            productCell.setCellValue(productNameText);

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            fileOutputStream.close();
            workbook.close();
            fileInputStream.close();

        } else if (name.equals("ürün tutarı")) {

            XSSFCell productPriceCell = sheet.getRow(0).createCell(column);
            productPriceCell.setCellValue(productPriceText);

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            fileOutputStream.close();
            workbook.close();
            fileInputStream.close();

        }
    }

    public void addToBasket() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,750)");
        BrowserUtils.waitForClickablility(addBasket, 10);
        addBasket.click();


    }


}
