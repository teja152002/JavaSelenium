package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Static block ensures Extent Reports is initialized automatically
    static {
        setupReport();
    }

    public static void setupReport() {
        if (extent == null) { // Prevent multiple instances
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/Report.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    public static void startTest(String testName) {
        if (extent == null) {
            setupReport(); // Ensure Extent is initialized before starting a test
        }
        test = extent.createTest(testName);
    }

    public static void log(String message) {
        if (test != null) {
            test.info(message);
        }
    }

    public static void logPass(String message) {
        if (test != null) {
            test.pass(message);
        }
    }

    public static void logFail(String message) {
        if (test != null) {
            test.fail(message);
        }
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void endReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
