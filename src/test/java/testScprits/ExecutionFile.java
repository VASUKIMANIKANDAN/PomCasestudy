package testScprits;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


import Pages.CartPage;
import Pages.HomePage;
import Pages.PurchasePage;
import Pages.LoginPage;
import base.TestBase;

public class ExecutionFile extends TestBase {
	LoginPage login;
	HomePage home;
	CartPage cart;
	PurchasePage order;
	WebDriverWait wait;
	
	@BeforeTest
	public void startup()
	{
		initialize();
	}
	
	
	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		login=new LoginPage();
		home=new HomePage();
		home.login.click();
		login.login(prop.getProperty("uname"), prop.getProperty("pass"));
		Assert.assertEquals(home.welcome.getText(),"Welcome Vasuki5456");			
	}
	
	@Test(dataProvider="data",priority=2)
	
	public void additem(String item)
	
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		home= new HomePage();
		cart= new CartPage();
		
		home.search(item);
		home.GoTOCart();
		wait.until(ExpectedConditions.visibilityOfAllElements(cart.items));
		boolean flag=false;
		for(WebElement cartslist: cart.items)
		  {
			  if(cartslist.getText().equalsIgnoreCase(item)) {
			  Assert.assertEquals(cartslist.getText(), item);
			  flag=true;
			  }			  
		  }
		Assert.assertTrue(flag);	  
	}

	@Test(priority=3)
	public void delete() throws InterruptedException
	{
		cart=new CartPage();
		order=new PurchasePage();
		boolean success= cart.delete();
		Assert.assertTrue(success);
	}
	
	@Test(priority=4)
	public void placeorder() throws InterruptedException 
	{
		order=new PurchasePage();
		cart=new CartPage();
		Thread.sleep(3000);
		cart.placeorder.click();
		order.confirmorder();
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));

		
	}
	
	 @DataProvider(name="data")
	  public Object[][] ProListCSV() throws CsvValidationException, IOException{
		  String path=System.getProperty("user.dir")+"//src//test//resources//testData//singledata.csv";
		  String[] cols;
		  CSVReader reader = new CSVReader(new FileReader(path));
		  ArrayList<Object> dataList=new ArrayList<Object>();
		  while((cols=reader.readNext())!=null)
		  {
			  Object[] record= {cols[0]};
			  dataList.add(record);
		  }
		  return dataList.toArray(new Object[dataList.size()][]);
		  
	  }
	

}
