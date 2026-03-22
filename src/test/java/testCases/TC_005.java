package testCases;

import java.time.Duration;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Searchpage;
import testBase.BaseClass;

public class TC_005 extends BaseClass
{
	
	@Test 
	public void verify_searchproduct()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Searchpage sp=new Searchpage(driver);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Automation Exercise";

		Assert.assertEquals(actualTitle, expectedTitle, "Home page title verification failed");
		
		   sp.productsbutton();
		   String at=sp.searchproducttitle();
		   Assert.assertEquals(at,"Automation Exercise - All Products","Navigation to All Products page failed");
		   
		   sp.searchproductfield();
		   sp.searchbutton();
		   String actualt=sp.searchedproducts();
		   Assert.assertEquals(actualt, "SEARCHED PRODUCTS","Searched Products title not displayed");
		   
		   List<String> sl=sp.searchResult();
		   
		 
		   for(String productName : sl)
		   {
		       Assert.assertTrue(productName.contains("top"),
		               "Product not related to search: " + productName);
		   }
		   
		
	
	}
}
