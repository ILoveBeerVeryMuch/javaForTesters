package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupCreation() {
    applicationManager.getNavigationHelper().goToGroupPage();
    if (!applicationManager.getGroupHelper().isThereAGroup()) {
      applicationManager.getGroupHelper().createGroup(new GroupData("groupName", "groupHeader", "groupFooter"));
      applicationManager.getNavigationHelper().returnOnGroupPage();
    }
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getNavigationHelper().returnOnGroupPage();
    applicationManager.getSessionHelper().logout();
  }

}
