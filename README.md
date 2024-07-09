# Java-Cucumber-Project
A repository to recall setting up Cucumber for Selenium testing.

# Table of Contents

## Steps to Setup
1. Setup Java Maven Project
    - In VSCode :
      ```
      CTRL + SHIFT + P
      ```
    - Then type in:
      ```
      Maven: New Project
      ```
    - Then click on the archetype:
      ```
      maven-archetype-quickstart
      ```
    - Then click on the version:
      ```
      1.4
      ```
    - Then type in your group id and project name
2. Add Dependencies to pom.xml
    ```
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.18.0</version>
        <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-junit</artifactId>
      <version>7.18.0</version>
      <scope>test</scope>
    </dependency>
    ```
3. Create a 'features' folder inside: 'src/test/resources'
4. Create a feature file inside the created 'feature' folder
    - Example: Login.feature
5. Add details to feature file:
    ```
    Example:
    Feature: feature to test login functionality
  
      Scenario: Check login is successful with valid credentials
  
          Given user is on login page
          When user enters username and password
          And user clicks on login button
          Then user is navigated to the home page
    ```
    - If you want to do a paramterized test, you can add a Scenario Outline:
      ```
      Feature: feature to test login functionality

        Scenario: Check login is successful with valid credentials
    
            Given user is on login page
    
            When user enters username and password
            And user clicks on login button
            Then user is navigated to the home page
    
        Scenario Outline: Check login is successful with valid credentials
    
            Given user is on login page
            
            When user enters <username> and <password>
            And user clicks on login button
            Then user is navigated to the home page
    
            Examples: 
            | username | password |
            | user1 | pass1 |
            | user2 | pass2 |
      ```
6. Create a new folder/package inside src/test/java named 'StepDefinitions'
7. Create new java file called 'LoginSteps.java' inside the new folder/package
   ```
   Example File:
   package StepDefinition;

   import io.cucumber.java.en.And;
   import io.cucumber.java.en.Given;
   import io.cucumber.java.en.Then;
   import io.cucumber.java.en.When;
   
   public class LoginSteps {
   
       @Given("user is on login page")
       public void user_is_on_login_page() {
   
           System.out.println("Inside Step - user is on login page.");
       }
   
       @When("user enters username and password")
       public void user_enters_username_and_password() {
   
           System.out.println("Inside Step - user enters username and password.");
       }
   
       @And("user clicks on login button")
       public void clicks_on_login_button() {
   
           System.out.println("Inside Step - user clicks on login button.");
       }
   
       @Then("user is navigated to the home page")
       public void user_is_navigated_to_the_home_page() {
   
           System.out.println("Inside Step - user is navigated to homepage.");
       }
   }
   ```
8. Create a new folder/package inside src/test/java named 'TestRunner'
9. Create new java file called 'RunCucumberTest.java' inside the new folder/package
   ```
   Example File:
   package TestRunner;

   import org.junit.runner.RunWith;
   
   import io.cucumber.junit.Cucumber;
   import io.cucumber.junit.CucumberOptions;
   
   @RunWith(Cucumber.class)
   @CucumberOptions(features = "src/test/java/alv/resources/features", glue = "StepDefinition")
   public class RunCucumberTest {
   }
   ```
   - You can also add monochrome to create a more color coded test result and can also add reports using plugin = {} inside @CucumberOptions.
     ```
     Example:
     @CucumberOptions(features = "src/test/java/alv/resources/features", glue = "StepDefinition", monochrome = true, plugin = {
        "pretty", "html:target/HtmlReports/report.html"})
     ```
     ```
     More Report Options:
     junit, html, pretty, progress, json, usage, unused, rerun, testng
     ```
