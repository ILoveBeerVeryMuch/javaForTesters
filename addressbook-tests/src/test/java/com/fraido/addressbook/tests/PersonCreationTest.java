package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import com.fraido.addressbook.model.Persons;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonCreationTest extends BaseTest {

  @Test
  public void testPersonCreation() {
    Persons before = applicationManager.person().all();
    PersonData personData = new PersonData().withFirstName("First name").withLastName("Last name").withNumber("88005553555")
            .withEmail( "test@test.com").withGroup("groupName");
    applicationManager.goTo().createPersonPage();
    applicationManager.person().create(personData);
    applicationManager.goTo().homePage();
    Persons after = applicationManager.person().all();
    assertThat(after.size() , equalTo(before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(personData.withId(after.stream().mapToInt(g ->g.getId()).max().getAsInt()))));

  }


}
