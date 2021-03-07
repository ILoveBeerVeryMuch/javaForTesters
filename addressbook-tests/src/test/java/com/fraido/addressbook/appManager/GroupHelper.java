package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitGroupForm() {
      click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupDate) {
      type(By.name("group_name"),groupDate.getGroupName());
      type(By.name("group_header"),groupDate.getGroupHeader());
      type(By.name("group_footer"),groupDate.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }
}
