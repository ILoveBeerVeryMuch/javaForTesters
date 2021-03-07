package com.fraido.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String login, String password) {
        type(By.name("user"),login);
        click(By.id("LoginForm"));
        type(By.name("pass"),password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
        click(By.linkText("Logout"));
    }
}
