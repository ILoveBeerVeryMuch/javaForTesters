package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroup(int index) {
        wd.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
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

    public void createGroup(GroupData groupDate) {
        initGroupCreation();
        fillGroupForm(new GroupData("groupName", "groupHeader", "groupFooter"));
        submitGroupForm();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.xpath("//input[@type='checkbox']"));
    }

    public int getGroupsCounter() {
        return wd.findElements(By.xpath("//input[@type='checkbox']")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements) {
            groups.add( new GroupData(element.getText(), null, null, Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"))));
        }
        return groups;
    }
}
