package com.gratis;

import com.gratis.pages.CiltBakimi;
import com.gratis.pages.MainPage;
import com.utils.TestBase;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

public class feature {

    MainPage mainPage = new MainPage();
    CiltBakimi ciltBakimiPage = new CiltBakimi();
    @Test
    public void e2eTest() {

        mainPage.goToMainPage();

        mainPage.validateTitle("Gratis | Türkiye'nin Kişisel Bakım Marketi");

        mainPage.mouseHover(mainPage.ciltBakimi);

        mainPage.clickSubContentRandom_Validate();

        ciltBakimiPage.chooseCheckBoxes();

        ciltBakimiPage.validateCheckBoxes();

        // chooseOneProduct();

        // textToExcelColumn("ürün bilgisi", writeExcelFile()[0]);

        // textToExcelColumn("ürün tutarı", writeExcelFile()[1]);

        // addToBasket();

        // validateLoginPage();

        // textToUsername(readExcelFile()[0])

        // textToPassword(readExcelFile()[1])

    }
}
