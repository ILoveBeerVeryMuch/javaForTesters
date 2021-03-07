package com.fraido.addressbook.tests;

import com.fraido.addressbook.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTest extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("groupName", "groupHeader", "groupFooter"));
    submitGroupForm();
    returnOnGroupPage();
    logout();
  }

  public void returnOnGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  private void submitGroupForm() {
    wd.findElement(By.name("submit")).click();
  }

  private void fillGroupForm(GroupData groupDate) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupDate.getGroupName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupDate.getGroupHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupDate.getGroupFooter());
  }

  private void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  private void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

}
