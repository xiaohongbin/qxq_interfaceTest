package QXQ.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    public static  synchronized ExtentReports getInstance(String filePath) {
        File reportDir = new File("test-output");
        if (!reportDir.exists() && !reportDir.isDirectory()) {
            reportDir.mkdir();
        }
        if (extent == null){
            createInstance(filePath);
        }

        return extent;
    }


        public static void createInstance(String filePath) {
        extent = new ExtentReports();
        extent.attachReporter(createHtmlReporter(filePath));


    }

    public static ExtentHtmlReporter createHtmlReporter(String filePath) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);

        htmlReporter.config().setDocumentTitle("趣相亲接口自动化测试报告");
        htmlReporter.config().setReportName("趣相亲接口自动化测试报告");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("GB2312");
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        return htmlReporter;
    }

//    public static ExtentXReporter createExtentXReporter(ExtentXReporter extentx) {
//
//        extent.setSystemInfo("OS_platform", "centos");
//        extentx.config().setProjectName("menghunli");
//        extentx.config().setReportName("Build-0.02");
//        extentx.config().setServerUrl("http://localhost:1337");
//        return extentx;
//    }


}
