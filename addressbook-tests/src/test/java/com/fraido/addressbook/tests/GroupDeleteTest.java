package com.fraido.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupCreation() {
    applicationManager.getNavigationHelper().goToGroupPage();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getNavigationHelper().returnOnGroupPage();
    applicationManager.getSessionHelper().logout();
  }

}
