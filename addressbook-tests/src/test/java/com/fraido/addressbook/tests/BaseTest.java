package com.fraido.addressbook.tests;

import com.fraido.addressbook.appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected final ApplicationManager applicationManager = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        applicationManager.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        applicationManager.stop();
    }

}
