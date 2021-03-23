package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.PersonData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PersonHelper extends BaseHelper{

    public PersonHelper(WebDriver wd) {
        super(wd);
    }

    public void submitPersonForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillPersonForm(PersonData person, boolean creation) {
        type(By.name("firstname"), person.getFirstName());
        type(By.name("lastname"), person.getLastName());
        type(By.name("mobile"), person.getNumber());
        type(By.name("email"), person.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(person.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void clickEditPerson(int index) {
        wd.findElements(By.xpath("//tr[@name='entry']")).get(index).findElement(By.xpath("//img[@title='Edit']")).click();
    }

    public void updatePersonForm() {
        click(By.name("update"));
    }

    public void deletePersonForm() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectPerson(int index) {
        wd.findElements(By.xpath("//tr[@name='entry']")).get(index).findElement(By.xpath("//input[@type='checkbox']")).click();
    }

    public void deletePerson() {
        click(By.xpath("//input[@value='Delete']"));
        confirm();
    }

    public boolean isThereAPerson() {
        return isElementPresent(By.xpath("//input[@type='checkbox']"));
    }

    public void createPerson() {
        fillPersonForm(new PersonData("First name", "Last name","88005553555", "test@test.com", "groupName"), true);
        submitPersonForm();
    }

    public List<PersonData> getPersonList() {
        List<PersonData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element: elements) {
            groups.add( new PersonData(element.findElement(By.xpath("(//td)[3]")).getText(), element.findElement(By.xpath("(//td)[2]")).getText(), element.findElement(By.xpath("(//td)[6]")).getText(), element.findElement(By.xpath("(//td)[5]")).getText(), "groupName", Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value" ))));
        }
        return groups;
    }
}
