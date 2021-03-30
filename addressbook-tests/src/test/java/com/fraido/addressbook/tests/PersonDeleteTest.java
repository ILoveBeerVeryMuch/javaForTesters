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
    if (applicationManager.person().all().size() == 0) {
      applicationManager.person().create( new PersonData().withFirstName("First name").withLastName("Last name").withNumber("88005553555")
              .withEmail( "test@test.com").withGroup("groupName"));
    }
  }

  @Test
  public void testPersonDeleteByMainPage() {
    Persons before = applicationManager.person().all();
    PersonData personData = before.iterator().next();
    applicationManager.person().delete(personData);
    Persons after = applicationManager.person().all();
    assertThat(after , equalTo(before.without(personData)));
  }


}
