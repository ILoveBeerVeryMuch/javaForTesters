package com.fraido.addressbook.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;

    private NavigationHelper navigationHelper;
    private GroupHelper groupsHelper;
    private PersonHelper personHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupsHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        personHelper = new PersonHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupsHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public PersonHelper getPersonHelper() {
        return personHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
