package testCases;


import Utils.CommonActions;
import browserFactory.BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.LoginForHrmPage;
import java.io.IOException;
import java.nio.file.WatchEvent;

import static Utils.CommonActions.driver;


public class PimHrmTestcases {
    public BaseClass bc;
    public LoginForHrmPage loginForHrm;



    @Test(priority = 1)
    public void launch() throws IOException {
        bc = new BaseClass();
        bc.launchBrowserAndExecution();
    }

    @Test(priority = 2)
    public void login() throws IOException, InterruptedException {
        loginForHrm = new LoginForHrmPage(driver);
        loginForHrm.setLogindetail();
    }



    @Test(priority = 10)
    public void quit() {
        CommonActions.tearDown();
    }
}

