package testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.Homepage;
import testbase.Baseclass;
import utilities.TestUtility;

public class TestClass  {
	WebDriver driver;
	Homepage hp;
	@BeforeClass
	public void beforeSetup() throws IOException
	{
		driver = Baseclass.setup();
		hp= new Homepage(driver);
		
	}
	
	@AfterClass
	public void tearDown() throws IOException
	{
		driver.quit();
		
	}
// Testcase to verify the title of the page
@Test
public void testcase001()
{
	hp.docs_series();
	TestUtility.embedScreenCapture();
	hp.clickdocs();
	TestUtility.embedScreenCapture();
	Assert.assertEquals(driver.getTitle(),"Series & Docs | TVO.org");
	
}
//Test case to verify that search button is displayed
@Test
public void testcase002() throws IOException 
{
	Assert.assertTrue(hp.searchButton());
	TestUtility.embedScreenCapture();

}
//Testcase to verify the title of page after clicking on TVO Today
@Test
public void testcase003() throws IOException
{
	hp.docs_series();
	hp.clickdocs();
	Assert.assertEquals(hp.tvo_home(),"TVO Today | Current Affairs Journalism, Documentaries and Podcasts");
	TestUtility.embedScreenCapture();
}
//Test case to chcek Nesletter button is working or not
@Test
public void testcase004()
{
	
	Assert.assertEquals(hp.newsletter_link(),"https://www.tvo.org/newsletters");
	TestUtility.embedScreenCapture();
}
//Test case to verify Load More button is displayed
@Test
public void testcase005()
{
	hp.docs_series();
	hp.clickdocs();
	Assert.assertTrue(hp.loadMoreButton());
	TestUtility.embedScreenCapture();
}

// Test case: checking without hovering over the element(copyright)
@Test
public void testcase006()
{
	
	Assert.assertEquals(hp.notUnderline(),"none solid rgb(255, 255, 255)");
	TestUtility.embedScreenCapture();
}
// Test case: executing after hovering over the element(copyright)
@Test
public void testcase007()
{
	
	Assert.assertEquals(hp.copyRightUnderline(),"underline solid rgb(255, 255, 255)");
	TestUtility.embedScreenCapture();
	
}
//Test case for checking the background color of Tvo Today
@Test
public void testcase008()
{
	
	Assert.assertEquals(hp.tvo_backgroudcolor(),"rgba(231, 19, 26, 1)");
	TestUtility.embedScreenCapture();
}
//Test case to verify video link is working 
@Test
public void testcase009()
{
	Assert.assertEquals(hp.video_links_working(),"https://www.tvo.org/video/documentaries/19-days");
	TestUtility.embedScreenCapture();
	
}
//Test case to verify navigation is working
@Test
public void testcase010()
{
	Assert.assertEquals(hp.back_nevigation(), "https://www.tvo.org/series-docs/browse/filters/docs");
	TestUtility.embedScreenCapture();
}
}