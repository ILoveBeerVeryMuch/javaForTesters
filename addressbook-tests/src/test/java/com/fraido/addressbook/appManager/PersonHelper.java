package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.PersonData;
import com.fraido.addressbook.model.Persons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PersonHelper extends BaseHelper{

    public PersonHelper(WebDriver wd) {
        super(wd);
    }

    public void submitPersonForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillForm(PersonData person, boolean creation) {
        type(By.name("firstname"), person.getFirstName());
        type(By.name("lastname"), person.getLastName());
        type(By.name("mobile"), person.getNumber());
        type(By.name("email"), person.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(person.getGroup());
        } else {
            selectGroupById(person.getId());
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void clickEditPerson() {
        wd.findElement(By.xpath("//img[@title='Edit']")).click();
    }

    public void updatePersonForm() {
        click(By.name("update"));
    }

    public void delete(PersonData personData) {
        selectGroupById(personData.getId());
        click(By.xpath("//input[@value='Delete']"));
        confirm();
    }

    public void create(PersonData personData) {
        fillForm( personData.withFirstName("First name").withLastName("Last name").withNumber("88005553555")
                .withEmail( "test@test.com").withGroup("groupName"), true);
        submitPersonForm();
    }

    public Persons all() {
        Persons persons = new Persons();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element: elements) {
                    persons.add( new PersonData().withFirstName(element.findElement(By.cssSelector("td:nth-child(3)")).getText())
                    .withLastName(element.findElement(By.cssSelector("td:nth-child(2)")).getText())
                    .withNumber(element.findElement(By.cssSelector("td:nth-child(6)")).getText())
                    .withEmail(element.findElement(By.cssSelector("td:nth-child(5)")).getText())
                    .withGroup("groupName")
                    .withId(Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"))));
        }
        return persons;
    }

    public void selectGroupById(int index) {
        wd.findElement(By.xpath(String.format("//input[@value='%s']", index))).click();
    }

    public void update(PersonData person) {
        selectGroupById(person.getId());
        clickEditPerson();
        type(By.name("firstname"), person.getFirstName());
        type(By.name("lastname"), person.getLastName());
        type(By.name("mobile"), person.getNumber());
        type(By.name("email"), person.getEmail());
        Assert.assertFalse(isElementPresent(By.name("new_group")));
        updatePersonForm();
    }
}
