package pocmetrics;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(BlockJUnit4ClassRunner.class)
public class Test extends TestCase{

    private static WebDriver driver;
    @BeforeClass
    public static void conf() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/manu/Documents/dev/workspace/dkt-perf-monitoring-poc/complete/chromedriver");
    }

    @AfterClass
    public static void quit() {

    }

    @org.junit.Test
    public  void testLoadPage() throws InterruptedException {
        int i = 10;
        while(i >= 0){
            driver = new ChromeDriver();
            driver.get("http://localhost:8080");
            Thread.sleep(1000);
            driver.quit();
            i--;
        }

    }
}
