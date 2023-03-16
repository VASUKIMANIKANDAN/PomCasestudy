package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class PurchasePage extends TestBase {
	
	
	
	@FindBy(xpath="(//button/span[text()='×'])[3]")
	public WebElement close;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='card']")
	WebElement card;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchase;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement accept;
	
	WebDriverWait wait;
	
	public PurchasePage()
	{
		PageFactory.initElements(driver, this);
	}
	public void confirmorder() throws InterruptedException
	
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		Thread.sleep(2000);
		name.sendKeys("sanjay");		
		country.sendKeys("country");
		city.sendKeys("city");
		card.sendKeys("card");
		month.sendKeys("month");
		year.sendKeys("2001");
		purchase.click();
		Thread.sleep(2000);
		accept.click();
		
		
		
	}
	

}
