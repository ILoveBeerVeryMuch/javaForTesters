package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.PersonData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class PersonCreationTest extends BaseTest {

  @Test
  public void testPersonCreation() {
    List<PersonData> before = applicationManager.getPersonHelper().getPersonList();
    applicationManager.getNavigationHelper().goToCreatePersonPage();
    applicationManager.getPersonHelper().createPerson();
    applicationManager.getNavigationHelper().returnToHomePage();
    List<PersonData> after = applicationManager.getPersonHelper().getPersonList();
    Comparator<? super PersonData> byId = (Comparator.comparingInt(PersonData::getId));
    before.add(new PersonData("First name", "Last name", "88005553555", "test@test.com", "groupName", after.stream().max(byId).get().getId()));
    before.sort(byId);
    after.sort(byId);
    System.out.println("before "+before.size());
    System.out.println("after "+after.size());
    Assert.assertEquals(before, after);
    applicationManager.getSessionHelper().logout();
  }


}
