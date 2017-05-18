package TestSuite;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

import PageObjects.Login;
import Utilities.*;

//@Listeners(Report.class)
public class TC01 {
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTestInterruptedException testexception;

	@Test
	@Parameters({ "Browser" })
	public void TC001() throws Exception {

		Login.Execute(driver);
		String sUserName = ExcelUtilities.getCellData(1, 1);

		String sPassword = ExcelUtilities.getCellData(1, 2);
		System.out.println(sUserName);
		System.out.println(sPassword);

		System.out
				.println("Login Successfully, now it is the time to Log Off buddy.");

		Reporter.log("Successful Logout |");

		ExcelUtilities.setCellData("Pass", 1, 3);

		Log.endTestCase("TC01");
		logger.addBase64ScreenShot("base64String");
	}

	@SuppressWarnings("unchecked")
	@BeforeTest
	public void beforeClass() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		extent = new ExtentReports(
				"C:\\Research\\Framework\\HtmlReport\\Tc001.html", true);
		extent.loadConfig(new File("extent-config.xml")); // Supporting File for
															// Extent Reporting
		@SuppressWarnings("rawtypes")
		Map sysInfo = new HashMap();
		sysInfo.put("Selenium Version", "2.53.1");
		sysInfo.put("Environment", "Prod");
		extent.addSystemInfo(sysInfo);	
		// Information
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.assignAuthor("Dipjyoti Metia");
		Log.startTestCase("TC01");

		// Get the data from excel
		ExcelUtilities.setExcelFile(Constant.Path_TestData
				+ Constant.File_TestData, "Sheet1");

		driver = new FirefoxDriver();
		Log.info("New driver instantiated");
		logger.log(LogStatus.PASS, "New Driver Initited");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(Constant.URL);
		Reporter.log("Successfully navigated to the URL |");
		logger.log(LogStatus.PASS, "Navigated to the new URL");
		driver.manage().window().maximize();
		logger.addScreenCapture("");
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
		extent.endTest(logger);
		extent.flush();
	}

}
