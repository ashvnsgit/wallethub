package WalletHub.Assignment;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	 static ExtentSparkReporter reporter;
	 static ExtentReports extent;
	@BeforeTest
	public static ExtentReports config()
	{
		String Path=System.getProperty("user.dir")+"\\reports\\index.html";
		reporter=new  ExtentSparkReporter(Path);
		reporter.config().setDocumentTitle("WalletHub");
		reporter.config().setReportName("Assignment");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ashish");
		return extent;
		
		
	}
	

}
