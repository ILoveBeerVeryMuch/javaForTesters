package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import com.fraido.addressbook.model.Persons;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonDeleteTest extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().persons().size() == 0) {
      app.person().create( new PersonData().withFirstName("First name").withLastName("Last name").withMobilePhone("88005553555")
              .withEmail( "test@test.com").withGroup("groupName"));
    }
  }

  @Test
  public void testPersonDeleteByMainPage() throws InterruptedException {
    app.goTo().homePage();
    Persons before = app.db().persons();
    PersonData personData = before.iterator().next();
    app.person().delete(personData);
    app.goTo().homePage();
    Persons after = app.db().persons();
    assertThat(after , equalTo(before.without(personData)));
  }


}
