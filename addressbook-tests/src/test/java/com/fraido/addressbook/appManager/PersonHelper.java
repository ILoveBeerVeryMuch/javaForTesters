package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.PersonData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonHelper extends BaseHelper{

    public PersonHelper(WebDriver wd) {
        super(wd);
    }

    public void submitPersonForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillPersonForm(PersonData person) {
        type(By.name("firstname"), person.getFirstName());
        type(By.name("middlename"), person.getMiddleName());
        type(By.name("lastname"), person.getLastName());
        type(By.name("nickname"), person.getNickname());
        type(By.name("title"), person.getTitle());
        type(By.name("company"), person.getCompany());
        type(By.name("mobile"), person.getNumber());
        type(By.name("email"), person.getEmail());
    }

}
