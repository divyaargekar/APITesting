Feature: Test to verify delete branch

  Scenario Outline: Test to verify deleting a added for the application
    Given user add the branch into the applicaiton with the uri "/qspiders/rest/branch"
      | location | <LOCATION> |
      | message  | <MESSAGE>  |
      | name     | <NAME>     |
    Then message "Successfully added branch" should be displayed
    When user delete the added branch "<NAME>" on the uri "/qspiders/rest/branch"
    #We need to discuss why we could not give the NAME above
    Then response code '200' should be displayed
    And message "Successfully Deleted the branch- <NAME>" should be displayed

    #How to write the generic one for the message
    Examples: 
      | LOCATION     | MESSAGE      | NAME       |
      | basvanagudi2 | sundayclass2 | pojoclass2 |
