package com.fraido.addressbook.model;

import java.util.Objects;

public class PersonData {
    private final String firstName;
    private final String lastName;;
    private final String number;
    private final String email;
    private final String group;
    private int id;

    public PersonData(String firstName, String lastName, String number, String email, String group, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.email = email;
        this.group = group;
        this.id = id;
    }

    public PersonData(String firstName, String lastName, String number, String email, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.email = email;
        this.group = group;
        this.id = Integer.MAX_VALUE;
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

    public String getGroup() { return group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonData that = (PersonData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + lastName + '\'' +
                '}';
    }
}
