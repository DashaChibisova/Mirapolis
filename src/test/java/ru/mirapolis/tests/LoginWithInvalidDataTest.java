package ru.mirapolis.tests;

import io.qameta.allure.junit4.DisplayName;
import ru.mirapolis.po.CustomLoginPage;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;


@RunWith(Parameterized.class)
public class LoginWithInvalidDataTest extends BaseClass {


    private String login;
    private String password;

    public LoginWithInvalidDataTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[] getLoginData() {
        return new Object[][]{
                {"", Data.PASSWORD_CORRECT},
                {Data.LOGIN_CORRECT, ""},
                {Data.inValidData(Data.LOGIN_CORRECT), Data.PASSWORD_CORRECT},
                {Data.LOGIN_CORRECT, Data.inValidData(Data.PASSWORD_CORRECT)}
        };
    }

    @DisplayName("Нельзя залогиниться в систему с некорректными данными")
    @Test
    public void notCanBeLoginWithInValidData() {
        CustomLoginPage loginPage = new CustomLoginPage(driver);
        loginPage
                .open()
                .login(login, password)
                .clickButtonEnter();

        String textOnAlert = loginPage.getTextAlert();
        String actual = "Неверные данные для авторизации.";
        MatcherAssert.assertThat(actual, containsString(textOnAlert));

    }
}

