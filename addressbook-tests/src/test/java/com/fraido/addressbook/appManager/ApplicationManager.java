package com.fraido.addressbook.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;

    private final Properties properties;
    private NavigationHelper navigationHelper;
    private GroupHelper groupsHelper;
    private PersonHelper personHelper;
    private SessionHelper sessionHelper;
    private String browser;
    private DBHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        dbHelper = new DBHelper();
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        groupsHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        personHelper = new PersonHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login(properties.getProperty("admin.login"), properties.getProperty("admin.password"));
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupsHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public PersonHelper person() {
        return personHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public DBHelper db() {
        return dbHelper;
    }
}
