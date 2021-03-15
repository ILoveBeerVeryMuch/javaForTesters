package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class PersonDeleteTest extends BaseTest {

  @Test
  public void testPersonDeleteByEditPage() {
    if (!applicationManager.getPersonHelper().isThereAPerson()) {
      applicationManager.getPersonHelper().createPerson();
      applicationManager.getNavigationHelper().returnToHomePage();
    }
    applicationManager.getPersonHelper().clickEditPerson();
    applicationManager.getPersonHelper().deletePersonForm();
    applicationManager.getSessionHelper().logout();
  }

  @Test
  public void testPersonDeleteByMainPage() {
    if (!applicationManager.getPersonHelper().isThereAPerson()) {
      applicationManager.getPersonHelper().createPerson();
      applicationManager.getNavigationHelper().returnToHomePage();
    }
    applicationManager.getPersonHelper().selectPerson();
    applicationManager.getPersonHelper().deletePerson();
    applicationManager.getSessionHelper().logout();
  }


}
