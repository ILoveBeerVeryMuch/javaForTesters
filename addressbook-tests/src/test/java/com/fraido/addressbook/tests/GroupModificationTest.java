package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends BaseTest {

  @Test
  public void testGroupModification() {
    applicationManager.getNavigationHelper().goToGroupPage();
    List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
    applicationManager.getGroupHelper().selectGroup(before.size()-1);
    applicationManager.getGroupHelper().initGroupModification();
    GroupData groupData = new GroupData("newGroupName", "newGroupHeader", "newGroupFooter", before.get(before.size()-1).getId());
    applicationManager.getGroupHelper().fillGroupForm(groupData);
    applicationManager.getGroupHelper().submitGroupModification();
    applicationManager.getNavigationHelper().returnOnGroupPage();
    List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
    before.remove(before.size()-1);
    before.add(groupData);
    Comparator<? super GroupData> byId = (Comparator.comparingInt(GroupData::getId));
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    applicationManager.getSessionHelper().logout();
  }

}
