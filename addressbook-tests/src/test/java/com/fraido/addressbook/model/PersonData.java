package com.fraido.addressbook.model;

import java.util.Objects;

public class PersonData {
    private String firstName;
    private  String lastName;;
    private  String number;
    private  String email;
    private  String group;
    private int id = Integer.MAX_VALUE;

    public PersonData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonData withNumber(String number) {
        this.number = number;
        return this;
    }

    public PersonData withEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonData withGroup(String group) {
        this.group = group;
        return this;
    }

    public PersonData withId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() { return group;}

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonData that = (PersonData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
