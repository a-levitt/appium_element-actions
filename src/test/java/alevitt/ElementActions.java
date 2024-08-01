package alevitt;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class ElementActions {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = DriverInitialization.initializeDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By views = AppiumBy.accessibilityId("Views");
        By textField = AppiumBy.accessibilityId("TextFields");
        By viewsMenu = AppiumBy.id("android:id/list");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");

        getAttributes(views, driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(views)).click();
        //driver.findElement(views).click();

        WebElement scroll = driver.findElement(viewsMenu);
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) scroll).getId(),
                "direction", "up",
                "percent", 0.75));

        driver.findElement(textField).click();

        driver.findElement(editText).sendKeys("Changed text");
        Thread.sleep(3000);
        driver.findElement(editText).clear();
    }

    public static void getAttributes(By locator, AppiumDriver driver) {
        System.out.println(driver.findElement(locator).getText() + " attributes:");
        System.out.println("checked: " + driver.findElement(locator).getAttribute("checked"));
        System.out.println("enabled: " + driver.findElement(locator).isEnabled());
        System.out.println("selected: " + driver.findElement(locator).isSelected());
        System.out.println("displayed: " + driver.findElement(locator).isDisplayed());
        System.out.println("");
    }
}
