package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTest extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition() {
    applicationManager.goTo().groupPage();
    if (applicationManager.group().all().size() == 0) {
      applicationManager.group().create(new GroupData().withName("groupName").withHeader("groupHeader").withFooter("groupFooter"));
      applicationManager.goTo().returnOnGroupPage();
    }
  }

  @Test
  public void testGroupDelete() {
    Groups before = applicationManager.group().all();
    GroupData deletedGroup = before.iterator().next();
    applicationManager.group().delete(deletedGroup);
    applicationManager.goTo().returnOnGroupPage();
    Groups after = applicationManager.group().all();
    assertThat(after , equalTo(before.without(deletedGroup)));
  }

}
