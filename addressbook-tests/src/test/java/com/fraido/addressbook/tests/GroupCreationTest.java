package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends BaseTest {

  @Test
  public void testGroupCreation() {
    applicationManager.getNavigationHelper().goToGroupPage();
    List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
    GroupData groupData = new GroupData("groupName", "groupHeader", "groupFooter");
    applicationManager.getGroupHelper().createGroup(groupData);
    applicationManager.getNavigationHelper().returnOnGroupPage();
    List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
    Comparator<? super GroupData> byId = (Comparator.comparingInt(GroupData::getId));
    groupData.setId(after.stream().max(byId).get().getId());
    before.add(groupData);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    applicationManager.getSessionHelper().logout();
  }

}
