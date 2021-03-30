package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import com.fraido.addressbook.model.Persons;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonModificationTest extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition() {
    if (applicationManager.person().all().size() == 0) {
      applicationManager.person().create( new PersonData().withFirstName("First name").withLastName("Last name").withNumber("88005553555")
              .withEmail( "test@test.com").withGroup("groupName"));
    }
  }

  @Test
  public void testPersonModification() {
    Persons before = applicationManager.person().all();
    PersonData modifiedPerson = before.iterator().next();
    PersonData newPerson = new PersonData().withFirstName("new first name")
            .withLastName("new last name")
            .withNumber("880099988877")
            .withEmail( "test1@test.com")
            .withId(modifiedPerson.getId());
    applicationManager.person().update(newPerson);
    applicationManager.goTo().homePage();
    Persons after = applicationManager.person().all();
    Assert.assertEquals(after, before.without(modifiedPerson).withAdded(newPerson));
  }


}
