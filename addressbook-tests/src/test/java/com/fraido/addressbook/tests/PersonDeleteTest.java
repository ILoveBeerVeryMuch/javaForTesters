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
    if (app.person().all().size() == 0) {
      app.person().create( new PersonData().withFirstName("First name").withLastName("Last name").withMobilePhone("88005553555")
              .withEmail( "test@test.com").withGroup("groupName"));
    }
  }

  @Test
  public void testPersonDeleteByMainPage() {
    app.goTo().homePage();
    Persons before = app.person().all();
    PersonData personData = before.iterator().next();
    app.person().delete(personData);
    Persons after = app.person().all();
    assertThat(after , equalTo(before.without(personData)));
  }


}
