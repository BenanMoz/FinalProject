package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {


        public void onStart(ITestContext execution){
            System.out.println("............starting execution..........");
    }

        public void onFinish(ITestContext execution){
        System.out.println("....................ending execution.............");
    }

      public void onTestSkipped(ITestContext execution) {
        System.out.println(".........skipping the test.......");
    }


        public void onTestStart(ITestResult test){
        System.out.println("....start test........ " + test.getName());
    }

        public void onTestSuccess(ITestResult test) {
            System.out.println("test .." + test.getName() + " passed");
            if (!getData("PlatformName").equalsIgnoreCase("api")) {
                try {
                    MonteScreenRecorder.stopRecord();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                File file = new File("./test-recordings/" + test.getName() + ".avi");
                if (file.delete())
                    System.out.println("success delete the files");
                else
                    System.out.println("fail to delete the file");

                saveScreenshot();
            }
        }
        public void onTestFailure(ITestResult test){
        System.out.println("test.." + test.getName() + " failed");
        if (!getData("PlatformName").equalsIgnoreCase("api")) {
                try {
            MonteScreenRecorder.stopRecord();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

            saveScreenshot();
    }}

        public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
            System.out.println("to do something");
    }

    @Attachment(value = "Page Screen-Shot" , type = "image/src")
    public byte[] saveScreenshot()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


    }


