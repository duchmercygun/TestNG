package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {

    //pre conditions

    public static WebDriver driver; //declaring webDriver in a global approach

    @BeforeMethod
    public void SetUp() { // preconditions to open the browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {//postCondition to close the browser
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void InvalidCredentials(){
        WebElement userName=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password=driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@name='Submit']"));
        loginBtn.click();

        WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMessage=error.getText();
        //check if the error message is correct
        String expectedError="Invalid credentials";

        if(errorMessage.equalsIgnoreCase(expectedError)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
    }
}