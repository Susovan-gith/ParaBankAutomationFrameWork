package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html");

            spark.config()
                 .setReportName("ParaBank Automation Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Tester",
                    "Susovan Maji");
        }

        return extent;
    }
}