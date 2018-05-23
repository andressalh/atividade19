package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author andreendo
 */
public class ActivityDiaryTest {
    
    //Apk file within the project
    private static String APKFILELOCATION = "C:\\Users\\andre\\Desktop\\8Sem\\topicos\\atividade19\\com.android2.calculator3_93.apk";
    protected AndroidDriver d;

    @Before
    public void before() throws MalformedURLException {
        File apkFile = new File(APKFILELOCATION);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "TestNexus");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void after() {
        if (d != null) {
            d.quit();
        }
    }

    @Test
    public void test01() {
        d.findElementById("com.android2.calculator3:id/digit_2").click();
        d.findElementById("com.android2.calculator3:id/digit_3").click();
        d.findElementById("com.android2.calculator3:id/op_add").click();
        d.findElementById("com.android2.calculator3:id/digit_2").click();
        d.findElementById("com.android2.calculator3:id/digit_3").click();
        d.findElementById("com.android2.calculator3:id/eq").click();
        
    
        assertEquals("46", d.findElement(By.id("com.android2.calculator3:id/formula")).getText()); 
    }
}
