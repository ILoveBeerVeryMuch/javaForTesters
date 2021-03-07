package com.fraido.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class PersonCreationTest extends BaseTest {


  @Test
  public void testPersonCreation() throws Exception {
    goToCreatePersonPage();
    fillPersonForm();
    submitPersonForm();
    returnToHomePage();
    logout();
  }

  private void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitPersonForm() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void fillPersonForm() {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("First name");
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys("Middle name");
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("Last name");
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys("Nickname");
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys("Title");
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys("Company");
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys("88005553555");
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("test@test.com");
  }

  private void goToCreatePersonPage() {
    wd.findElement(By.linkText("add new")).click();
  }


}
