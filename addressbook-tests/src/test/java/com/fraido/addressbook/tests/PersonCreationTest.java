package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import org.testng.annotations.*;

public class PersonCreationTest extends BaseTest {

  @Test
  public void testPersonCreation() {
    applicationManager.getNavigationHelper().goToCreatePersonPage();
    applicationManager.getPersonHelper().createPerson();
    applicationManager.getNavigationHelper().returnToHomePage();
    applicationManager.getSessionHelper().logout();
  }


}
