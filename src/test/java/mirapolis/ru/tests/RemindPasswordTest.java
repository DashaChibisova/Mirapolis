package mirapolis.ru.tests;

import io.qameta.allure.Description;
import mirapolis.ru.po.CustomLoginPage;
import org.junit.Assert;
import org.junit.Test;

import static mirapolis.ru.tests.Data.LOGIN_CORRECT;
import static mirapolis.ru.tests.Data.inValidData;

public class RemindPasswordTest extends BaseClass {
    private  Data data = new Data();

    @Description("Восстановление пароля по корректному логину")
    @Test
    public void remindPasswordWithValidData() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        String actual = loginPage
                .open()
                .clickButtonRemindPassword()
                .inputUserLogin(LOGIN_CORRECT)
                .getMassageSuccess();

        String expected = "На ваш электронный адрес отправлена инструкция по восстановлению пароля.";
        Assert.assertEquals(expected, actual);
    }

    @Description("Восстановление пароля по некорректному логину")
    @Test
    public void remindPasswordWithInValidData() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        String actual = loginPage
                .open()
                .clickButtonRemindPassword()
                .inputUserLogin(inValidData(LOGIN_CORRECT))
                .getMassageFailure();

        String expected = "Пользователь с таким именем не найден.";
        Assert.assertEquals(expected, actual);
    }
}
