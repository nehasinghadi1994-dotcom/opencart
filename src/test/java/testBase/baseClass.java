package testBase;

import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass {

    public Properties p;
    public WebDriver driver;

    @BeforeClass(groups={"Sanity","Regression","Master","DataDriven"})
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws Exception {

        // Load config file
        FileReader file = new FileReader("C:\\Users\\hp\\eclipse-workspace\\Java_Project_With_Selenium\\Opencart28\\src\\test\\resources\\config.properties");
        p = new Properties();
        p.load(file);

        // Remote execution
        if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {

            DesiredCapabilities capabilities = new DesiredCapabilities();

            // OS
            if(os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            }
            else if(os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            }

            // Browser
            switch(br.toLowerCase()) {

                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;

                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        }

        // Local execution
        else {
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }

    @AfterClass(groups={"Sanity","Regression","Master"})
    public void tearDown() {
        driver.quit();
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumberic() {
        return RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomNumeric(5);
    }
}