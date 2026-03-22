package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Searchpage extends Basepage 
{
	public Searchpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement products;
	
	@FindBy (xpath="//input[@id='search_product']")
	WebElement txtsearchproduct;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement btnsearch;
	
	@FindBy(xpath="//h2[normalize-space()='Searched Products']")
	WebElement txtserachedproduct;
	
	@FindBy(xpath="//div[@class='productinfo text-center']")
	List<WebElement> lstsearchresult;
	
	public void productsbutton()
	{
		products.click();
	}
	public String searchproducttitle()
	{
		String allproductpagetitle=driver.getTitle();
		return allproductpagetitle;
	}
	
	public void searchproductfield()
	{
		txtsearchproduct.sendKeys("top");
		
		System.out.println(" printing statement");
		
	}
	public void searchbutton()
	{
		btnsearch.click();
	}
	public String searchedproducts()
	{
		String actualtxt=txtserachedproduct.getText();
		return actualtxt;
	}
	
	public List<String> searchResult()
	{
		List<String> productNames = new ArrayList<>();

	    for(WebElement searchlist : lstsearchresult)
	    {
	        productNames.add(searchlist.getText().toLowerCase());
	    }

	    return productNames;
	}

}
