package tests;

import com.codeborne.selenide.Configuration;
import data.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import steps.Steps;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class AbstractTest {


    @BeforeSuite(alwaysRun = true)
    public void configOptions() {
        Configuration.timeout = 20000;
        //Configuration.browserSize = "1600x940";
        //Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 60000;
        //Configuration.browserSize = "1600x920";
        Configuration.browser = "chrome";
        Configuration.browserCapabilities.setCapability("goog:chromeOptions", Map.of( "args",
                List.of("–no-sandbox", "–disable-dev-shm-usage", "–remote-debugging-port=9222") ));
    }

    // @BeforeClass(alwaysRun = true)
    // public static void setUp() {
    //     //Url удалённого веб драйвера
    //     Configuration.remote = "http://localhost:4444/wd/hub";
    //     //Размер окна браузера
    //     //Создаём объект класса DesiredCapabilities, используется как настройка  вашей конфигурации с помощью пары ключ-значение
    //     DesiredCapabilities capabilities = new DesiredCapabilities();
    //     //Включить поддержку отображения экрана браузера во время выполнения теста
    //     capabilities.setCapability("enableVNC", true);
    //     //Включение записи видео в процессе выполнения тестов
    //     capabilities.setCapability("enableVideo", true);
    //     //Переопределяем Browser capabilities
    //     Configuration.browserCapabilities = capabilities;
    // }

    @BeforeMethod(alwaysRun = true)
    public void before(){
        //open(Properties.get(Properties.MVIDEO_HOST));
        open(Properties.MVIDEO_HOST.getValue());
        Steps.homePage.checkThatHomePageOpen();
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        closeWebDriver();
    }


}
