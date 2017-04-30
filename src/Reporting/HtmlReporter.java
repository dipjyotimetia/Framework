package Reporting;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;

public class HtmlReporter {
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTestInterruptedException testexception;
	
	@SuppressWarnings("unchecked")
	public static void ExtentReport(String path,ExtentTest logger){
		extent = new ExtentReports(
				path, true);
		extent.loadConfig(new File("extent-config.xml")); // Supporting File for
															// Extent Reporting
		@SuppressWarnings("rawtypes")
		Map sysInfo = new HashMap();
		sysInfo.put("Selenium Version", "2.53.1");
		sysInfo.put("Environment", "Prod");
		extent.addSystemInfo(sysInfo);	
		// Information
//		logger = extent.startTest(this.getClass().getSimpleName());
		
	}
}
