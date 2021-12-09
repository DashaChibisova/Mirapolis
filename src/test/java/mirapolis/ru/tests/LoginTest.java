package mirapolis.ru.tests;

import io.qameta.allure.Description;
import mirapolis.ru.po.CustomLoginPage;
import mirapolis.ru.po.MainPage;
import org.junit.Assert;
import org.junit.Test;

import static mirapolis.ru.tests.Data.LOGIN_CORRECT;
import static mirapolis.ru.tests.Data.PASSWORD_CORRECT;


public class LoginTest extends BaseClass {

    @Description("Можно залогиниться в систему")
    @Test
    public void canBeLoginWithValidData() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        loginPage
                .open()
                .login(LOGIN_CORRECT, PASSWORD_CORRECT)
                .clickButtonEnter();
        MainPage mainPage = new MainPage(driver);

        String titleMainPage = mainPage.getTextTitleMainPage();

        Assert.assertEquals("Главная страница", titleMainPage);
    }

    @Description("Поле для пароля защифровано")
    @Test
    public void canBeSecurityPassword() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        boolean securityPassword = loginPage
                .open()
                .login(LOGIN_CORRECT, PASSWORD_CORRECT)
                .isSecurityPassword();

        Assert.assertTrue(securityPassword);
    }
}
