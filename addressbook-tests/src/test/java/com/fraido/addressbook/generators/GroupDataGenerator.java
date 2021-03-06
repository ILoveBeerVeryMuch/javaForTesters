package com.fraido.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.fraido.addressbook.model.GroupData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;
    @Parameter(names = "-d", description = "File format")
    public String format;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator groupDataGenerator = new GroupDataGenerator();
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
        List<GroupData> groups = generateGroups(count);
        if (format.equals("json"))
            saveAsJson(groups, new File(file));
        else
            saveAsCsv(groups, new File(file));
    }

    private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (GroupData group : groups) {
                writer.write(String.format("%s; %s; %s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
            }
        }
    }

    private static void saveAsJson(List<GroupData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupData().withName(String.format("test %s", i))
                    .withFooter(String.format("footer %s", i))
                    .withHeader(String.format("header %s", i)));
        }
        return groups;
    }
}
