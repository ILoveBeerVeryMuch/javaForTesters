package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.PersonData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonEmailTest extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.person().all().size() == 0) {
      app.person().create( new PersonData().withFirstName("First name").withLastName("Last name").withNumber("88005553555")
              .withEmail( "test@test.com").withGroup("groupName"));
    }
  }

  @Test
  public void emailTest() {
    app.goTo().homePage();
    PersonData person = app.person().all().iterator().next();
    PersonData personFromEditForm = app.person().infoFromEditPage(person);
    assertThat(person.getEmail(), equalTo((mergeEmails(personFromEditForm))));
  }

  private static String cleaned(String email) {
    return email.replace("\\s", "").replace("[-()]", "");
  }

  private String mergeEmails(PersonData contact) {
    return Arrays.asList(contact.getFirstEmail(),contact.getSecondEmail(), contact.getThirdEmail())
            .stream()
            .filter(s -> ! s.equals(""))
            .map(PersonEmailTest::cleaned)
            .collect(Collectors.joining("\n"));
  }


}
