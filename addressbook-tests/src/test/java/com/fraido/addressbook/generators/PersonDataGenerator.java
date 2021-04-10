package com.fraido.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.PersonData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PersonDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;
    @Parameter(names = "-d", description = "File format")
    public String format;

    public static void main(String[] args) throws IOException {
        PersonDataGenerator groupDataGenerator = new PersonDataGenerator();
        JCommander jcom = new JCommander(groupDataGenerator);
        try {
            jcom.parse(args);
        } catch(ParameterException exception) {
            jcom.usage();
            return;
        }
        groupDataGenerator.run();
    }

    private void run() throws IOException {
        List<PersonData> persons = generatePersons(count);
        if (format.equals("json"))
            saveAsJson(persons, new File(file));
        else
            saveAsCsv(persons, new File(file));
    }

    private static void saveAsJson(List<PersonData> persons, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(persons);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsCsv(List<PersonData> persons, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (PersonData person : persons) {
            writer.write(String.format("%s;%s;%s;%s\n", person.getFirstName(), person.getLastName(), person.getEmail(),
            person.getMobilePhone()));
        }
        writer.close();
    }

    private List<PersonData> generatePersons(int count) {
        List<PersonData> person = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            person.add(new PersonData().withFirstName(String.format("fist name %s", i))
                    .withLastName(String.format("last name %s", i))
                    .withEmail(String.format("test%s@mail.ru", i))
                    .withMobilePhone(String.format("8800555355%s", i).substring(0,11)));
        }
        return person;
    }
}
