package alevitt;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

public class ActionsWithApp {
    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = DriverInitialization.initializeDriverClear();
        String appState = String.valueOf(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));

        ((AndroidDriver) driver).installApp("D:\\Appium\\course_proj1\\ApiDemos-debug.apk",
                new AndroidInstallApplicationOptions().withTimeout(Duration.ofSeconds(10)));

        System.out.println("App installed: " + ((AndroidDriver) driver).isAppInstalled("io.appium.android.apis"));

        System.out.println(appState);
        ((AndroidDriver) driver).activateApp("io.appium.android.apis");

        ((AndroidDriver) driver).runAppInBackground(Duration.ofSeconds(5));

        System.out.println(appState);
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");

    }
}
