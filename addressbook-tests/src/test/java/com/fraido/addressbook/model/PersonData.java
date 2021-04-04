package com.fraido.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.Objects;

public class PersonData {
    @Expose
    private String firstName;
    @Expose
    private  String lastName;;
    private  String number;
    @Expose
    private  String emails;
    private  String group;
    private int id = Integer.MAX_VALUE;
    private String homePhone;
    @Expose
    private String mobilePhone;
    private String workPhone;
    private String allPhones;
    private String firstEmail;
    private String secondEmail;
    private String thirdEmail;
    private File photo;

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

    public PersonData withEmail(String emails) {
        this.emails = emails;
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

    public PersonData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public PersonData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public PersonData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public PersonData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public PersonData withFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
        return this;
    }

    public PersonData withSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
        return this;
    }

    public PersonData withThirdEmail(String thirdEmail) {
        this.thirdEmail = thirdEmail;
        return this;
    }

    public PersonData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String allPhones() {
        return number;
    }

    public String getEmail() {
        return emails;
    }

    public String getGroup() { return group;}

    public int getId() {
        return id;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getThirdEmail() {
        return thirdEmail;
    }

    public File getPhoto() {
        return photo;
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
