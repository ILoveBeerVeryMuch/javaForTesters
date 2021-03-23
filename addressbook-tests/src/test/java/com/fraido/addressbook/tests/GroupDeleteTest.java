package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupDelete() {
    applicationManager.getNavigationHelper().goToGroupPage();
    if (!applicationManager.getGroupHelper().isThereAGroup()) {
      applicationManager.getGroupHelper().createGroup(new GroupData("groupName", "groupHeader", "groupFooter"));
      applicationManager.getNavigationHelper().returnOnGroupPage();
    }
    List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
    applicationManager.getGroupHelper().selectGroup(before.size()-1);
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getNavigationHelper().returnOnGroupPage();
    List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
    
    applicationManager.getSessionHelper().logout();
  }

}
