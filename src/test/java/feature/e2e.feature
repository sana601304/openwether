#Author: Sana Mulla
#Date: Sunday, 4th Aug 2019 (Version 1.0)

Feature: E2E Open Weather Scenarios

  Scenario: Verify Home Page
    Given Navigate to Open Weather Map website
    When Home page is displayed
    Then Verify elements on Home Page

  Scenario Outline: Verify Valid and Invalid city weather results
    Given Navigate to Open Weather Map website
    When Enter <City> name and Search
    Then Verify weather <results>

    Examples:
    |City     |results  |
    |Mumbai   |Valid    |
    |TestCity |Invalid  |


  Scenario: Verify Response of API with City ID
    Given Execute service with CityID
    Then Validate the Status Code
