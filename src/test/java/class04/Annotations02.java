package class04;

import org.testng.annotations.*;

public class Annotations02 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }
    @BeforeMethod
    public void before(){
        System.out.println("I am before Method");
    }
    @AfterMethod
    public void after(){
        System.out.println("I am after Method");
    }
    @Test
    public void TestA(){
        System.out.println("I am test A");
    }
    @Test
    public void TestB(){
        System.out.println("I am test B");
    }
}
