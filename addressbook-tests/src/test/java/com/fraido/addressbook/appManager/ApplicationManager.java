package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.PersonData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;

    private NavigationHelper navigationHelper;
    private GroupHelper groupsHelper;
    private PersonHelper personHelper;
    private SessionHelper sessionHelper;

    public void init() {
        wd = new FirefoxDriver();
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
