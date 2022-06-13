package com.common.helpers.Wrappers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.common.helpers.web.BaseBrowser.driver;


public class TakeScreenShot {

	public static String takeSnapShot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,
				new File("TestReport\\" + name + ".png"));
		return name;
	}

}
