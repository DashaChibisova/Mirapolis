package ru.mirapolis.tests;

import io.qameta.allure.junit4.DisplayName;
import ru.mirapolis.po.CustomLoginPage;
import org.junit.Assert;
import org.junit.Test;

public class RemindPasswordTest extends BaseClass {
    private Data data = new Data();

    @DisplayName("Восстановление пароля по корректному логину")
    @Test
    public void remindPasswordWithValidData() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        String actual = loginPage
                .open()
                .clickButtonRemindPassword()
                .inputUserLogin(Data.LOGIN_CORRECT)
                .getMassageSuccess();

        String expected = "На ваш электронный адрес отправлена инструкция по восстановлению пароля.";
        Assert.assertEquals(expected, actual);
    }

    @DisplayName("Восстановление пароля по некорректному логину")
    @Test
    public void remindPasswordWithInValidData() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        String actual = loginPage
                .open()
                .clickButtonRemindPassword()
                .inputUserLogin(Data.inValidData(Data.LOGIN_CORRECT))
                .getMassageFailure();

        String expected = "Пользователь с таким именем не найден.";
        Assert.assertEquals(expected, actual);
    }
}
