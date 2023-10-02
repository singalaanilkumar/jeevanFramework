package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;

public class LoginForHrmPage   {
    WebDriver driver;
    @FindBy(css = "input[placeholder='Username']")
    WebElement uname;
    @FindBy(css = "input[placeholder='Password']")
    WebElement pword;
    @FindBy(css = "button[type='submit']")
    WebElement LogIn_Button;

    /*initializing the page objects*/
    public LoginForHrmPage(WebDriver driver) {
        this.driver=driver;//using help of this keyword local variable driver invoked to pagemodel contructor.
        PageFactory.initElements( driver,this);//intialize the elements of
    }


    public void  setLogindetail() throws IOException, InterruptedException {
        uname.sendKeys("Admin");
        pword.sendKeys("admin123");
        LogIn_Button.click();

    }

    }



