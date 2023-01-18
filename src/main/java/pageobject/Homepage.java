package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	// this webdriver is private because we are not extending this page class
	private WebDriver driver;
	//constructor
	public Homepage(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver,this);
	}

	 @FindBy(xpath="//div[text()='Docs & Series']")
	 WebElement docseries;
	 
	 @FindBy(xpath="//span[text()='Docs']")
	 WebElement docs;
	 
	 @FindBy(xpath="//button[@aria-label='go to search page']")
	 WebElement search;
	 
	 @FindBy(xpath="//a[@aria-label='home']")
	 WebElement home;
	 
	 @FindBy(xpath="//div[text()='Newsletter']")
	 WebElement news_link;
	 
	 @FindBy(xpath="//span[text()='Load More']")
	 WebElement loadMore;
	 
	 @FindBy(xpath="//span[text()='A-Z']")
	 WebElement a_z;
	 
	 @FindBy(xpath="//a[text()='Copyright']")
	 WebElement copy_right;
	 
	 @FindBy(xpath="//span[text()='Terms of Use']")
	 WebElement terms;
	 
	 @FindBy(xpath="//a[@aria-label='TVO Today Home']")
	 WebElement tvo_home;
	 
	 @FindBy(xpath="//p[text()='19 Days']")
	 WebElement videoLink;
	 
public void docs_series()
{
	docseries.click();
}
public void clickdocs()
{
	
	docs.click();
}
public boolean searchButton() {
	//search.click();
		boolean b= false;
		try {
			b=search.isDisplayed();
			//b=true;
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return b;
	
}
public String tvo_home()
{
	home.click();
	String d = driver.getTitle();
	System.out.println(d);
	return d;
	
	}
public String newsletter_link()
{
	news_link.click();
	String n = driver.getCurrentUrl();
	return n;
}
public boolean loadMoreButton()
{
	
	boolean l= loadMore.isDisplayed();
	System.out.println(l);
	return l;
}

public String copyRightUnderline()
{

	Actions actions = new Actions(driver);
	actions.moveToElement(copy_right);
	actions.perform();
	String decoration = copy_right.getCssValue("text-decoration");
	System.out.println(decoration);
	return decoration;
}


public String notUnderline()
{
	String t =copy_right.getCssValue("text-decoration");
	System.out.println(t);
	return t;
}

public String tvo_backgroudcolor()
{
	String t= tvo_home.getCssValue("background-color");
	return t;
}
public String video_links_working()
{
	JavascriptExecutor j=(JavascriptExecutor) driver;
	
	j.executeScript("arguments[0].click();",videoLink);
		String n = driver.getCurrentUrl();
		return n;
	
}
public String back_nevigation()
{
	driver.navigate().back();
	String n = driver.getCurrentUrl();
	return n;
}
}
