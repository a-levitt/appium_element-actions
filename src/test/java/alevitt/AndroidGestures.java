package alevitt;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;

public class AndroidGestures {
    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = DriverInitialization.initializeDriver();

        // longClickGesture(driver);
        dragGesture(driver);
    }


        public static void longClickGesture(AppiumDriver driver) {
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

            WebElement longTouchCircle = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

            // mobile: touchAndHold
            driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                    // "elementId", ((RemoteWebElement) longTouchCircle).getId(),
                    "x", 230,
                    "y", 650,
                    "duration", 1500
            ));
        }

        public static void dragGesture(AppiumDriver driver) {
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

            WebElement longTouchCircle = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

            driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) longTouchCircle).getId(),
                    "endX", 615,
                    "endY", 550
            ));
        }
}
