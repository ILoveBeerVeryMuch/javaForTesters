package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends BaseTest {

  @Test
  public void testGroupCreation() {
    applicationManager.getNavigationHelper().goToGroupPage();
    applicationManager.getGroupHelper().createGroup(new GroupData("groupName", "groupHeader", "groupFooter"));
    applicationManager.getNavigationHelper().returnOnGroupPage();
    applicationManager.getSessionHelper().logout();
  }

}
