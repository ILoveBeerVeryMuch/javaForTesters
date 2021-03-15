package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.PersonData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
        if (isElementPresent(By.name("new_group"))) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(person.getGroup());
        }
    }

    public void clickEditPerson() {
        click(By.xpath("//img[@title='Edit']"));
    }

    public void updatePersonForm() {
        click(By.name("update"));
    }

    public void deletePersonForm() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectPerson() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void deletePerson() {
        click(By.xpath("//input[@value='Delete']"));
        confirm();
    }

    public boolean isThereAPerson() {
        return isElementPresent(By.xpath("//input[@type='checkbox']"));
    }

    public void createPerson() {
        fillPersonForm(new PersonData("First name", "Middle name", "Last name", "Nickname", "Title", "Company", "88005553555", "test@test.com", "groupName"));
        submitPersonForm();
    }
}
