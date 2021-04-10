package com.fraido.addressbook.appManager;

import com.fraido.addressbook.model.Groups;
import com.fraido.addressbook.model.PersonData;
import com.fraido.addressbook.model.Persons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PersonHelper extends BaseHelper{
    private Persons personCache = null;

    public PersonHelper(WebDriver wd) {
        super(wd);
    }

    public void submitPersonForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillForm(PersonData person, boolean creation) {
        type(By.name("firstname"), person.getFirstName());
        type(By.name("lastname"), person.getLastName());
        type(By.name("mobile"), person.getMobilePhone());
        type(By.name("email"), person.getEmail());
        attach(By.name("photo"), person.getPhoto());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(person.getGroup());
        } else {
            selectGroupById(person.getId());
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void clickEditPerson(int index) {
        wd.findElement(By.xpath(String.format("//a[@href='edit.php?id=%s']", index))).click();
    }

    public void updatePersonForm() {
        click(By.name("update"));
    }

    public void delete(PersonData personData) {
        selectGroupById(personData.getId());
        click(By.xpath("//input[@value='Delete']"));
        personCache = null;
        confirm();
    }

    public void create(PersonData personData) {
        fillForm( personData.withFirstName(personData.getFirstName()).withLastName(personData.getLastName())
                .withMobilePhone(personData.getMobilePhone())
                .withEmail(personData.getEmail())
                .withGroup("groupName")
                .withPhoto(personData.getPhoto()), true);
        submitPersonForm();
        personCache = null;
    }

    public Persons all() {
        if (personCache != null) {
            return new Persons(personCache);
        }
        personCache = new Persons();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element: elements) {
            personCache.add( new PersonData().withFirstName(element.findElement(By.cssSelector("td:nth-child(3)")).getText())
                    .withLastName(element.findElement(By.cssSelector("td:nth-child(2)")).getText())
                    .withEmail(element.findElement(By.cssSelector("td:nth-child(5)")).getText())
                    .withAllPhones(element.findElement(By.cssSelector("td:nth-child(6)")).getText())
                    .withGroup("groupName")
                    .withId(Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")))) ;
        }
        return new Persons(personCache);
    }

    public void selectGroupById(int index) {
        wd.findElement(By.xpath(String.format("//input[@value='%s']", index))).click();
    }

    public void update(PersonData person) {
        clickEditPerson(person.getId());
        type(By.name("firstname"), person.getFirstName());
        type(By.name("lastname"), person.getLastName());
        type(By.name("mobile"), person.getMobilePhone());
        type(By.name("email"), person.getEmail());
        Assert.assertFalse(isElementPresent(By.name("new_group")));
        updatePersonForm();
        personCache = null;
    }

    public PersonData infoFromEditPage(PersonData person) {
        clickEditPerson(person.getId());
        return new PersonData().withId(person.getId()).withFirstName(wd.findElement(By.name("firstname")).getText())
                .withLastName(wd.findElement(By.name("lastname")).getAttribute("value"))
                .withEmail(wd.findElement(By.name("email")).getAttribute("value"))
                .withMobilePhone(wd.findElement(By.name("mobile")).getAttribute("value"))
                .withHomePhone(wd.findElement(By.name("home")).getAttribute("value"))
                .withWorkPhone(wd.findElement(By.name("work")).getAttribute("value"))
                .withFirstEmail(wd.findElement(By.name("email")).getAttribute("value"))
                .withSecondEmail(wd.findElement(By.name("email2")).getAttribute("value"))
                .withThirdEmail(wd.findElement(By.name("email3")).getAttribute("value"));
    }
}
