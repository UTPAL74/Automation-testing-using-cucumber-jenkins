Feature: visit a page on google.

  Scenario: Open browser and visit any web page.
    Given I visit the website
    And I entered username password and click continue
    | username      | password |
    | utpal.kumar74 | test123  |
    And I close the website after some time