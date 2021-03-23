package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class PersonModificationTest extends BaseTest {

  @Test
  public void testPersonModification() {
    List<PersonData> before = applicationManager.getPersonHelper().getPersonList();
    applicationManager.getPersonHelper().clickEditPerson();
    PersonData personData = new PersonData("new first name",  "new last name", "880099988877", "test1@test.com", null);
    applicationManager.getPersonHelper().fillPersonForm(personData, false);
    applicationManager.getPersonHelper().updatePersonForm();
    applicationManager.getNavigationHelper().returnToHomePage();
    List<PersonData> after = applicationManager.getPersonHelper().getPersonList();
    Comparator<? super PersonData> byId = (Comparator.comparingInt(PersonData::getId));
    before.remove(before.size()-1);
    personData.setId(after.stream().max(byId).get().getId());
    before.add(personData);
    before.sort(byId);
    after.sort(byId);
    System.out.println(before.get(before.size()-1));
    System.out.println(after.get(after.size()-1));
    System.out.println(before);
    System.out.println(after);
    Assert.assertEquals(before, after);
    applicationManager.getSessionHelper().logout();

  }


}
