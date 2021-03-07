package com.fraido.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper{
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void goToCreatePersonPage() {
        click(By.linkText("add new"));
    }

    public void returnOnGroupPage() {
        click(By.linkText("group page"));
    }
}
