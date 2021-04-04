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
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("groupName").withHeader("groupHeader").withFooter("groupFooter"));
      app.goTo().returnOnGroupPage();
    }
  }

  @Test
  public void testGroupDelete() {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    app.goTo().returnOnGroupPage();
    Groups after = app.group().all();
    assertThat(after , equalTo(before.without(deletedGroup)));
  }

}
