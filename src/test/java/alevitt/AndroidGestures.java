package alevitt;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;

public class AndroidGestures {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = DriverInitialization.initializeDriver();
        //AppiumDriver map_driver = DriverInitialization.initializeDriver_Maps();

        //longClickGesture(driver);
        //dragGesture(driver);

        //clickGesture_MapsSkip(map_driver);
        //pinchOpenGesture(map_driver);
        //pinchCloseGesture(map_driver);

        swipeGesture(driver);

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

    public static void clickGesture_MapsSkip(AppiumDriver driver) {

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", 945,
                "y", 135
        ));
    }

    public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        //WebElement zoomInMap = driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/explore_tab_home_bottom_sheet"));
        Thread.sleep(5000);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
               //"elementId", ((RemoteWebElement) zoomInMap).getId(),
                "left", 200,
                "top", 470,
                "width", 600,
                "height", 600,
                "percent", 0.75
        ));
    }

    public static void pinchCloseGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(6000);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                //"elementId", ((RemoteWebElement) zoomInMap).getId(),
                "left", 200,
                "top", 470,
                "width", 600,
                "height", 600,
                "percent", 0.75
        ));
    }

    public static void swipeGesture(AppiumDriver driver) {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "up",
                "percent", 0.75
        ));
    }
}
