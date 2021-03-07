package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import org.testng.annotations.*;

public class PersonCreationTest extends BaseTest {


  @Test
  public void testPersonCreation() {
    applicationManager.getNavigationHelper().goToCreatePersonPage();
    applicationManager.fillPersonForm(new PersonData("First name", "Middle name", "Last name", "Nickname", "Title", "Company", "88005553555", "test@test.com"));
    applicationManager.submitPersonForm();
    applicationManager.getNavigationHelper().returnToHomePage();
    applicationManager.logout();
  }


}
