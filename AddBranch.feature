Feature: Adding Branch to the qspiders application
  As admin user I should be able to add the branch into the qspiders application

  Scenario Outline: Test to verify adding a branch into the application
    Given user add the branch into the applicaiton with the uri "/qspiders/rest/branch"
      | location | <LOCATION> |
      | message  | <MESSAGE>  |
      | name     | <NAME>     |
    Then message "Successfully added branch" should be displayed

    Examples: 
      | LOCATION     | MESSAGE      | NAME |
      | basvanagudi2 | sundayclass2 |      |
