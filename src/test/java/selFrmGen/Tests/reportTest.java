package selFrmGen.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportTest {

	ExtentReports extent;
	
	@BeforeTest
	public void reportConf() {
		//ExtentReports; ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Hello report");
		reporter.config().setDocumentTitle("Hi title");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vikas");
		
	}
	
	@Test
	public void reporttest1() {
		
//		extent.createTest("reporttest1");
		ExtentTest test = extent.createTest("reporttest1");
		System.out.println("hello");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rc03989\\OneDrive - Ryan LLC\\Documents\\Vikas\\PP-Se\\chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		test.fail("intentional fail");
		extent.flush();
		
		
	}
	
}

