Feature: Test to verify the get branch details from the qspiders application
  As a Admin user
  I am interested in verifying the default branches and new branches added to the application

  Scenario: To verify the default branches present in a application
    Given user access the application with the uri "/qspiders/rest/branch"
    Then response code '202' should be displayed
    And the default branches should be available
      | Electrical Science  |
      | Computer Science    |
      | Mechanical          |
      | Information Science |
#
  #Scenario: To verify the get api uri with wrong value
    #Given user access the application with the uri "/qspiders/rest/branch1"
    #Then response code '404' should be displayed
#
  #Scenario: To verify the default branch location
    #Given user access the application with the uri "/qspiders/rest/branch"
    #Then response code '202' should be displayed
    #And the default branches location should be present
      #| name                | location           |
      #| Electrical Science  | CV Raman block     |
      #| Computer Science    | Aryabhatta block   |
      #| Mechanical          | Visvesvaraya block |
      #| Information Science | Abdul Kalam block  |
