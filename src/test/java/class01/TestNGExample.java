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

public class TestNGExample {

    //TestCase1
    //go to syntax hrms
    //enter the userName and password, verify that you logged on
    //close the browser

    public static WebDriver driver; //declaring webDriver in a global approach
   @BeforeMethod(alwaysRun = true)
    public void  SetUp(){ // preconditions to open the browser
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   }

   @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {//postCondition to close the browser
       Thread.sleep(5000);
      driver.quit();
   }

   @Test(groups = "regression")
    public void LoginFunctionality(){
       WebElement userName=driver.findElement(By.xpath("//input[@name='txtUsername']"));
       userName.sendKeys("Admin");
       WebElement password=driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
       password.sendKeys("Hum@nhrm123");
       WebElement loginBtn=driver.findElement(By.xpath("//input[@name='Submit']"));
       loginBtn.click();
   }
   //TestCase2
   //Verify that password textBox is displayed on the logIn page

    @Test
    public void passwordTextBoxVerification(){
       WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        System.out.println(password.isDisplayed());

    }

}
