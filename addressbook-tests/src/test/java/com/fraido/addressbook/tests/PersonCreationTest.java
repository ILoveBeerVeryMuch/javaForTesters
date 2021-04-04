package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import com.fraido.addressbook.model.Persons;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonCreationTest extends BaseTest {

  @Test
  public void testPersonCreation() {
    app.goTo().homePage();
    Persons before = app.person().all();
    PersonData personData = new PersonData().withFirstName("First name").withLastName("Last name").withMobilePhone("88005553555")
            .withEmail( "test@test.com").withGroup("groupName");
    app.goTo().createPersonPage();
    app.person().create(personData);
    app.goTo().homePage();
    Persons after = app.person().all();
    assertThat(after.size() , equalTo(before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(personData.withId(after.stream().mapToInt(g ->g.getId()).max().getAsInt()))));

  }


}
