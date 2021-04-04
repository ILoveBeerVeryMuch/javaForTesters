package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("groupName").withHeader("groupHeader").withFooter("groupFooter"));
      app.goTo().returnOnGroupPage();
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData groupData =  new GroupData().withName("groupName").withHeader("groupHeader").withFooter("groupFooter").withId(modifiedGroup.getId());
    app.group().modify(groupData);
    app.goTo().returnOnGroupPage();
    Groups after = app.group().all();
    assertThat(before.size() , equalTo(after.size()));
    assertThat(after , equalTo(before.without(modifiedGroup).withAdded(groupData)));
  }

}
