package com.gratis;

import com.gratis.pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class feature extends MainPage {

    @Test
    public void e2eTest(){

        goToMainPage();

        validateTitle("Gratis | Türkiye'nin Kişisel Bakım Marketi");

       // mouseHover("cilt bakımı");

       //  clickSubContentRandom();

        // validateUrlContain();

        // chooseCheckBoxes();

        // validateCheckBoxes();

        // chooseOneProduct();

        // textToExcelColumn("ürün bilgisi", writeExcelFile()[0]);

        // textToExcelColumn("ürün tutarı", writeExcelFile()[1]);

        // addToBasket();

        // validateLoginPage();

        // textToUsername(readExcelFile()[0])

        // textToPassword(readExcelFile()[1])

    }
}
