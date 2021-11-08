package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNgG {
static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String Path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter  reporter=new ExtentSparkReporter(Path);
		reporter.config().setReportName("WebTesting");
		reporter.getConf().setDocumentTitle("Test Result");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Ashish");
		return extent;
		
		
		
	}
}
