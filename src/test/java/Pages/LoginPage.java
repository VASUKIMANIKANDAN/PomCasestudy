package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoginPage extends TestBase {
	

	
	@FindBy(id="loginusername")
	WebElement username;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginbtn;
	
	
	
	WebDriverWait wait;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String user, String pass)
	
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(60));
		
		
		
		username.sendKeys(user);
//		wait.until(ExpectedConditions.)
		password.sendKeys(pass);
		loginbtn.click();
		//return new ();
	}
}