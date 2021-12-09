package mirapolis.ru.po;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RemindPasswordPage extends PageBase {

    public RemindPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@name= 'loginOrEmail']")
    public WebElement loginWeb;

    @FindBy(xpath = "//*[@class = 'mira-page-forgot-password-button']")
    public WebElement buttonSend;

    @FindBy(xpath = "//*[@class = 'success']")
    public WebElement textMassageSuccess;

    @FindBy(xpath = "//*[@class = 'alert']")
    public WebElement textMassageFailure;
    @Step
    public RemindPasswordPage inputUserLogin(String login){
        loginWeb.sendKeys(login);
        return this;
    }
    @Step
    public void clickButtonSend(){
        buttonSend.click();
    }
    @Step
    public String getMassageSuccess(){
        clickButtonSend();
        wait.until(ExpectedConditions.visibilityOf(textMassageSuccess));
        return textMassageSuccess.getText();
    }
    @Step
    public String getMassageFailure(){
        clickButtonSend();
        wait.until(ExpectedConditions.visibilityOf(textMassageFailure));
        return textMassageFailure.getText();
    }
}
