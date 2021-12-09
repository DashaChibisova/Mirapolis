package mirapolis.ru.po;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CustomLoginPage extends PageBase {

    public CustomLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id = 'login_form_panel']//*[@name = 'user']")
    public WebElement loginWeb;

    @FindBy(xpath = "//*[@id = 'login_form_panel']//*[@name = 'password']")
    public WebElement passwordWeb;

    @FindBy(xpath = "//*[@id = 'button_submit_login_form']")
    public WebElement buttonEnter;

    @FindBy(xpath = "//*[@class ='links-container']//*[contains(text(),'Забыли пароль?')]")
    public WebElement buttonRemindPassword;

    public CustomLoginPage inputUserLogin(String login) {
        loginWeb.sendKeys(login);
        return this;
    }

    @Step
    public CustomLoginPage open() {
        driver.get(URL);
        return this;
    }

    @Step
    public CustomLoginPage inputUserPassword(String password) {
        passwordWeb.sendKeys(password);
        return this;
    }
    @Step
    public CustomLoginPage login(String login,String password){
        inputUserLogin(login);
        inputUserPassword(password);
        return this;
    }
    @Step
    public void clickButtonEnter()  {
      buttonEnter.click();
    }
    @Step
    public String getTextAlert(){
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        return textOnAlert;
    }
    @Step
    public boolean isSecurityPassword(){
        return passwordWeb.getAttribute("type").equals("password");
    }
    @Step
    public RemindPasswordPage clickButtonRemindPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class= 'links-container']//div[contains(text(), 'Забыли пароль?')]")));
        buttonRemindPassword.click();
        wait.until(ExpectedConditions.titleContains("Восстановление пароля"));
        return new RemindPasswordPage(driver);
    }

    private static final String URL = "https://lmslite47vr.demo.mirapolis.ru/mira";
}
