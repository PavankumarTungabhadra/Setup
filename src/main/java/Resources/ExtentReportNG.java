package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject()
	{
		ExtentSparkReporter reporter= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//index.html");
		reporter.config().setReportName("ExecutionReport");
		reporter.config().setDocumentTitle("Automation execution");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pavankumar T");
		return extent;
	}

}
