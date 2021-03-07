package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import org.testng.annotations.Test;

public class PersonModificationTest extends BaseTest {

  @Test
  public void testPersonModification() {
    applicationManager.getPersonHelper().clickEditPerson();
    applicationManager.getPersonHelper().fillPersonForm(new PersonData("new first name", "new middle name", "new last name", "new nickname", "new  title", "new company", "880099988877", "test1@test.com"));
    applicationManager.getPersonHelper().updatePersonForm();
    applicationManager.getNavigationHelper().returnToHomePage();
    applicationManager.getSessionHelper().logout();

  }


}
