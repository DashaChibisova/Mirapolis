package ru.mirapolis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;


    @Before
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, TIME);
    }

    @After
    public void tearDown()
    {
        driver.quit();
        driver = null;
    }

    private static final int TIME = 10;
}
