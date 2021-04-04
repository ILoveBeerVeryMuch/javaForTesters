package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends BaseTest {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData groupData = new GroupData().withName("groupName").withHeader("groupHeader").withFooter("groupFooter");
    app.group().create(groupData);
    app.goTo().returnOnGroupPage();
    Groups after = app.group().all();
    assertThat(after.size() , equalTo(before.size()+1));
    assertThat(after , equalTo(
            before.withAdded(groupData.withId(after.stream().mapToInt(g ->g.getId()).max().getAsInt()))));

  }

}
