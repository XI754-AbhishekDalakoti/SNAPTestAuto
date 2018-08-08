package com.liveperson.ephemerals.examples;

import com.liveperson.ephemerals.AppiumAndroidEphemeral;
import com.liveperson.ephemerals.junit.EphemeralResource;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;


public class AppiumAndroidEphemeralTest extends EphemeralAbstractTest {

    static DesiredCapabilities CAPS;

    static {
        Map<String, Object> caps = new HashMap<>();
        caps.put("deviceName","Android Emulator");
        caps.put("platformVersion", "4.4");
        caps.put("app", "http://github.com/appium/sample-code/blob/master/sample-code/apps/ContactManager/ContactManager.apk?raw=true");
        caps.put("appPackage", "com.example.android.contactmanager");
        caps.put("appActivity", ".ContactManager");
        caps.put("newCommandTimeout",600);
        CAPS = new DesiredCapabilities(caps);
    }

    @Rule
    public EphemeralResource<AndroidDriver> seleniumResource = new EphemeralResource(
            new AppiumAndroidEphemeral.Builder(getKubernetesDeploymentContext())
                    .withDesiredCapabilities(CAPS)
                    .build());

    @Test
    public void test() {

        AndroidDriver androidDriver = seleniumResource.get();

        WebDriverWait webDriverWait = new WebDriverWait(androidDriver,60);

        WebElement addContactButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@text='Add Contact']")));
        addContactButton.click();

    }

}