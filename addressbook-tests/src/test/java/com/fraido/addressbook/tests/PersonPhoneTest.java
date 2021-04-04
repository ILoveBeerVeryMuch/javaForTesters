package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonPhoneTest extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.person().all().size() == 0) {
      app.person().create( new PersonData().withFirstName("First name").withLastName("Last name").withMobilePhone("88005553555")
              .withEmail( "test@test.com").withGroup("groupName"));
    }
  }

  @Test
  public void phoneTest() {
    app.goTo().homePage();
    PersonData person = app.person().all().iterator().next();
    PersonData personFromEditForm = app.person().infoFromEditPage(person);
    assertThat(person.getAllPhones(), equalTo((mergePhones(personFromEditForm))));
  }

  private static String cleaned(String phone) {
    return phone.replace("\\s", "").replace("[-()]", "");
  }

  private String mergePhones(PersonData contact) {
    return Arrays.asList(contact.getMobilePhone(),contact.getHomePhone(), contact.getWorkPhone())
            .stream()
            .filter(s -> ! s.equals(""))
            .map(PersonPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }


}
