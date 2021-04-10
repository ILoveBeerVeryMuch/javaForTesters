package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.PersonData;
import com.fraido.addressbook.model.Persons;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonCreationTest extends BaseTest {

  @DataProvider
  public Iterator<Object[]> validPersons() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/persons.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new PersonData().withFirstName(split[0])
              .withLastName(split[1])
              .withEmail(split[2])
              .withMobilePhone(split[3])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> validGPersonsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/persons.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<PersonData> persons = gson.fromJson(json, new TypeToken<List<PersonData>>(){}.getType());
    return persons.stream().map(g -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test (dataProvider = "validGPersonsFromJson")
  public void testPersonCreation(PersonData personData) {
    app.goTo().homePage();
    File photo = new File("src/test/resources/cat.jpg");
    Persons before = app.person().all();
    app.goTo().createPersonPage();
    app.person().create(personData.withPhoto(photo));
    app.goTo().homePage();
    Persons after = app.person().all();
    assertThat(after.size() , equalTo(before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(personData.withId(after.stream().mapToInt(g ->g.getId()).max().getAsInt()))));

  }


}
