package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends BaseTest {

  @Test
  public void testGroupModification() {
    applicationManager.getNavigationHelper().goToGroupPage();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().initGroupModification();
    applicationManager.getGroupHelper().fillGroupForm(new GroupData("newGroupName", "newGroupHeader", "newGroupFooter"));
    applicationManager.getGroupHelper().submitGroupModification();
    applicationManager.getNavigationHelper().returnOnGroupPage();
    applicationManager.getSessionHelper().logout();
  }

}
