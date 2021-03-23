package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.PersonData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PersonDeleteTest extends BaseTest {

  @Test
  public void testPersonDeleteByEditPage() {
    if (!applicationManager.getPersonHelper().isThereAPerson()) {
      applicationManager.getPersonHelper().createPerson();
      applicationManager.getNavigationHelper().returnToHomePage();
    }
    List<PersonData> before = applicationManager.getPersonHelper().getPersonList();
    applicationManager.getPersonHelper().clickEditPerson(before.size()-1);
    applicationManager.getPersonHelper().deletePersonForm();
    List<PersonData> after = applicationManager.getPersonHelper().getPersonList();
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
    applicationManager.getSessionHelper().logout();
  }

  @Test
  public void testPersonDeleteByMainPage() {
    if (!applicationManager.getPersonHelper().isThereAPerson()) {
      applicationManager.getPersonHelper().createPerson();
      applicationManager.getNavigationHelper().returnToHomePage();
    }
    List<PersonData> before = applicationManager.getPersonHelper().getPersonList();
    applicationManager.getPersonHelper().selectPerson(before.size()-1);
    applicationManager.getPersonHelper().deletePerson();
    List<PersonData> after = applicationManager.getPersonHelper().getPersonList();
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
    applicationManager.getSessionHelper().logout();
  }


}
