package class01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGAnnotations {

    @Test(groups = "regression")
    public void AFirstTestCase() {
        System.out.println("I am the first test case");
    }

    @Test
    public void BSecondTestCase() {
        System.out.println("I am the second test case");
    }

    @Test
    public void CThirdTestCase() {
        System.out.println("I am the third test case");
    }

    @BeforeMethod
    public void beforeMethods() {
        System.out.println("I am before method");
    }
}
