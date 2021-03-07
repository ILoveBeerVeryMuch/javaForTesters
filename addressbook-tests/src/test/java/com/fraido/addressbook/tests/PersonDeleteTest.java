package com.fraido.addressbook.tests;

import org.testng.annotations.Test;

public class PersonDeleteTest extends BaseTest {

  @Test
  public void testPersonDeleteByEditPage() {
    applicationManager.getPersonHelper().clickEditPerson();
    applicationManager.getPersonHelper().deletePersonForm();
    applicationManager.getNavigationHelper().returnToHomePage();
    applicationManager.getSessionHelper().logout();
  }

  @Test
  public void testPersonDeleteByMainPage() {
    applicationManager.getPersonHelper().selectPerson();
    applicationManager.getPersonHelper().deletePerson();
    applicationManager.getSessionHelper().logout();
  }


}
