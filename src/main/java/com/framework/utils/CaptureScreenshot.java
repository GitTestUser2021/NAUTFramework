package com.framework.utils;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.webdrivers.WebDriverManager;

/*
 * Class to capture UI screenshot
 * 
 * @author 10675365
 * 
 */

public class CaptureScreenshot {
	static String format = "png";
	public static String imageFolderPath = null;

	private static int count = 0;

	public static synchronized String screenCapture(String fileName) {

		String screenshotName = "";

		if (fileName != null) {
			screenshotName = fileName;

		} else {
			screenshotName = "screenshot" + (++count);
		}

		PropertyFileUtils extentPro = new PropertyFileUtils("./src/test/resources/extent.properties");
		String sparkDirPath = "./" + extentPro.getProperty("extent.reporter.spark.scr");

		Shutterbug.shootPage(WebDriverManager.getDriver(), true).withName(screenshotName).save(sparkDirPath);
		return screenshotName + ".png";
	}

	public static synchronized String captureEntireScreen() {

		String screenshotName = "screenshot" + (++count);

		PropertyFileUtils extentPro = new PropertyFileUtils("./src/test/resources/extent.properties");
		String sparkDirPath = "./" + extentPro.getProperty("extent.reporter.spark.scr");

		Shutterbug.shootPage(WebDriverManager.getDriver(), Capture.FULL_SCROLL, true).withName(screenshotName)
				.save(sparkDirPath);
		return screenshotName + ".png";
	}

}
