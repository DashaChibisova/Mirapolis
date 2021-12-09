package mirapolis.ru.po;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public String getTextTitleMainPage() {
        wait.until(ExpectedConditions.titleContains("Главная страница"));
        return driver.getTitle();

    }
}
