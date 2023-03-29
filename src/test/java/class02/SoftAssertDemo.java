package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;



public class SoftAssertDemo {
    public static WebDriver driver;
    @BeforeMethod
    public void SetUp() { // preconditions to open the browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    public void testCase(){
        //find the element of logIn button and click
        WebElement logIn= driver.findElement(By.xpath("//input[@id='btnLogin']"));
        logIn.click();
        //get the text error message
        WebElement error=driver.findElement(By.xpath("//span[text()='Username cannot be empty']"));
        String actualError= error.getText();
        //string that contains my expected error
        String expectedError="Username cannot be empty";

        //for soft assertion
        SoftAssert soft=new SoftAssert();
        //compare
        soft.assertEquals(actualError,expectedError);
        //logIn button is displayed or not
        boolean disp=logIn.isDisplayed();
        System.out.println("the state of the display is "+disp);
        //call the soft assertion
        soft.assertTrue(disp);
        //soft.assertTrue(false); - this will fail the soft assertion

        soft.assertAll();




    }

}


