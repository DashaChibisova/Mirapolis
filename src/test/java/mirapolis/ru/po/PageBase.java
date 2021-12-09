package mirapolis.ru.po;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
       wait = new WebDriverWait(driver, TIME);
    }

    private static final int TIME = 10;
}
