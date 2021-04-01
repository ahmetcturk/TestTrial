
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 {
    // In this example, we will go to a webpage and check different functionalities

    public WebDriver driver;
    String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void checkTitle(){
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void checkForgotPswLink(){
        By link = By.xpath("//*[@id='forgotPasswordLink']/a");
        driver.findElement(link).click();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
