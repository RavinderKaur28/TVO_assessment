package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import testbase.Baseclass;

public class TestUtility extends Baseclass {
	
	public static void captureScreenshot() throws IOException
	{
		File nfile = new File ("./screenshot");
		if(!nfile.isDirectory())
		{
			nfile.mkdir();
		}
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		File file = tk.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file,new File("./"+"screenshot/"+getDate()+"_image.jpg"));
	}
	public static void embedScreenCapture()
	{
		TakesScreenshot tc = (TakesScreenshot) driver;
		String src = tc.getScreenshotAs(OutputType.BASE64);
		String image="<img src=\"data:image/png;base64," + src +"\" height=\"600\"width=\"800\"/>";
		Reporter.log(image);
	}
	
	private static String getDate()
	{
		Date dt= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSS");
		String temp = sdf.format(dt);
		System.out.println(temp);
		return temp;
	}
	
	}
