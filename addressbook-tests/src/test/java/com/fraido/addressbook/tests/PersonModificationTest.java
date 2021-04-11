package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import com.fraido.addressbook.model.Persons;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonModificationTest extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().persons().size() == 0) {
      app.person().create( new PersonData().withFirstName("First name").withLastName("Last name").withMobilePhone("88005553555")
              .withEmail("test@test.com").withGroup("groupName"));
    }
  }

  @Test
  public void testPersonModification() {
    app.goTo().homePage();
    Persons before = app.db().persons();
    PersonData modifiedPerson = before.iterator().next();
    PersonData newPerson = new PersonData().withFirstName("new first name")
            .withLastName("new last name")
            .withMobilePhone("880099988877")
            .withFirstEmail( "test1@test.com")
            .withId(modifiedPerson.getId());
    app.person().update(newPerson);
    app.goTo().homePage();
    Persons after = app.db().persons();
    Assert.assertEquals(after, before.without(modifiedPerson).withAdded(newPerson));
  }


}
