package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    String browser;

    public void launchBrowserAndExecution() throws IOException {
        ConfigRead(); // Moved the loadConfig() call inside the method body
        if (browser == null) {
            throw new IllegalStateException("Browser is not initialized. Please call ConfigRead() method first.");
        }
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            System.out.println(browser);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("InternetExplorer")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions fo = new FirefoxOptions();
            fo.setHeadless(false);
            driver = new FirefoxDriver(fo);
        }
        driver.manage().window().maximize();
        driver.get("url");
    }

    public static ChromeOptions incognitoChromeLaunch() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setAcceptInsecureCerts(true);
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--start-maximized");
        co.addArguments("--incognito");
        co = co.merge(caps);
        return co;
    }

    public void ConfigRead() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Configuration/config.properties");
        prop.load(fis);
        String browser = prop.getProperty("browser");
        String Url = prop.getProperty("url");
        String Headless = prop.getProperty("Headless");
        String incognito = prop.getProperty("incognito");
        this.browser = browser;
    }
}
