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
    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("groupName").withHeader("groupHeader").withFooter("groupFooter"));
      app.goTo().returnOnGroupPage();
    }
  }

  @Test
  public void testGroupDelete() {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    app.goTo().returnOnGroupPage();
    Groups after = app.db().groups();
    assertThat(after , equalTo(before.without(deletedGroup)));
  }

}
