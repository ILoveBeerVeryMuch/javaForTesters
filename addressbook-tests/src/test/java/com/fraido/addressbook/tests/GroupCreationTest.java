package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends BaseTest {

  @Test
  public void testGroupCreation() {
    applicationManager.goToGroupPage();
    applicationManager.getGroupHelper().initGroupCreation();
    applicationManager.getGroupHelper().fillGroupForm(new GroupData("groupName", "groupHeader", "groupFooter"));
    applicationManager.getGroupHelper().submitGroupForm();
    applicationManager.getGroupHelper().returnOnGroupPage();
    applicationManager.logout();
  }

}
