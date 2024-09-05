package com.page.object;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCode {
	public static String passScreenCapture(WebDriver driver, String Str) throws IOException {
		Date d = new Date();
		// System.out.println(d.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		// Your each screenshot will be taken as this format
		// "Year-Month-Date-Hours-Minutes-Seconds"        
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/MEIURKADjangoTesting/" + Str + "-" + sdf.format(d) + ".png";
		FileUtils.copyFile(scrFile, new File(path));
		// your screenshot path and convert date string to SimpleDateFormat because
		// windows can't capture screenshot with(:)      
		return path;
	}
}
