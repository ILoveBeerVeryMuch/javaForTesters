package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelper extends BaseHelper {
    private Groups groupCache = null;

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

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void create(GroupData groupDate) {
        initGroupCreation();
        fillGroupForm(groupDate);
        submitGroupForm();
        groupCache = null;
    }

    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements) {
            groupCache.add(new GroupData().withName(element.getText()).withHeader(null).withFooter(null).withId(Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"))));
              }
        return new Groups(groupCache);
    }

    public void modify(GroupData groupData) {
        selectGroupById(groupData.getId());
        initGroupModification();
        fillGroupForm(groupData);
        submitGroupModification();
        groupCache = null;
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        groupCache = null;
        deleteGroup();
    }

    public void selectGroupById(int index) {
        wd.findElement(By.xpath(String.format("//input[@value='%s']", index))).click();
    }
}
