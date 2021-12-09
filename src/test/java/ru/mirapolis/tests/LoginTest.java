package ru.mirapolis.tests;

import io.qameta.allure.junit4.DisplayName;
import ru.mirapolis.po.CustomLoginPage;
import ru.mirapolis.po.MainPage;
import org.junit.Assert;
import org.junit.Test;


public class LoginTest extends BaseClass {

    @DisplayName("Можно залогиниться в систему")
    @Test
    public void canBeLoginWithValidData() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        loginPage
                .open()
                .login(Data.LOGIN_CORRECT, Data.PASSWORD_CORRECT)
                .clickButtonEnter();
        MainPage mainPage = new MainPage(driver);

        String titleMainPage = mainPage.getTextTitleMainPage();

        Assert.assertEquals("Главная страница", titleMainPage);
    }

    @DisplayName("Поле для пароля зашифровано")
    @Test
    public void canBeSecurityPassword() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        boolean securityPassword = loginPage
                .open()
                .login(Data.LOGIN_CORRECT, Data.PASSWORD_CORRECT)
                .isSecurityPassword();

        Assert.assertTrue(securityPassword);
    }
}
