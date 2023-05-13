package com.gratis;

import com.gratis.pages.CiltBakimi;
import com.gratis.pages.LoginBox;
import com.gratis.pages.MainPage;
import com.gratis.pages.ProductPage;
import com.utils.TestBase;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

public class feature {

    MainPage mainPage = new MainPage();
    CiltBakimi ciltBakimiPage = new CiltBakimi();
    ProductPage productPage = new ProductPage();
    LoginBox loginBox = new LoginBox();

    @Test
    public void e2eTest() {

        mainPage.goToMainPage();

        mainPage.validateTitle("Gratis | Türkiye'nin Kişisel Bakım Marketi");

        mainPage.mouseHover(mainPage.ciltBakimi);

        mainPage.clickSubContentRandom_Validate();

        ciltBakimiPage.chooseCheckBoxes();

        ciltBakimiPage.validateCheckBoxes();

        ciltBakimiPage.chooseOneProduct();

        productPage.textToExcelColumn("ürün bilgisi", 1);

        productPage.textToExcelColumn("ürün tutarı", 2);

        productPage.addToBasket();

        loginBox.validateLoginPage();

        loginBox.textToUsername(loginBox.readExcelFile()[0]);

        loginBox.textToPassword(loginBox.readExcelFile()[1]);

    }
}
