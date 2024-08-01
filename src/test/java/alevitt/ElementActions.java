package alevitt;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;

public class ElementActions {
    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = DriverInitialization.initializeDriver();

        WebElement menuElementViews = driver.findElement(AppiumBy.accessibilityId("Views"));
        menuElementViews.click();

        WebElement scroll = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) scroll).getId(),
                "direction", "up",
                "percent", 0.75));

        WebElement viewsElementTextField = driver.findElement(AppiumBy.accessibilityId("TextFields"));
        viewsElementTextField.click();
    }
}
