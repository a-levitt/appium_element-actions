package alevitt;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

public class ScreenLock {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = DriverInitialization.initializeDriverClear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ((AndroidDriver) driver).lockDevice(Duration.ofSeconds(5));
        System.out.println("Device is locked for 5 seconds");

        Thread.sleep(5000);

        ((AndroidDriver) driver).lockDevice();
        System.out.println("Device is locked: " + ((AndroidDriver) driver).isDeviceLocked());

        Thread.sleep(3000);

        ((AndroidDriver) driver).unlockDevice();
        System.out.println("Device is locked: " + ((AndroidDriver) driver).isDeviceLocked());
    }
}
