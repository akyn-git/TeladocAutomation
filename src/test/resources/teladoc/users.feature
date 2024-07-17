Feature: add user functionality

  Scenario Outline: Happy path add new user
    Given user is on main page of way2automation web app
    When user clicks on add user button window modal is visible
    When user adds a user with the following details '<FirstName>' '<LastName>' '<UserName>' '<Password>' '<Role>' '<Email>' '<CellPhone>'
    Then user clicks on save button
    Then user validates test account ont the table
    Examples:
      | FirstName | LastName | UserName | Password | Role  | Email            | CellPhone  |
      | John      | Doe      | johndoe  | password | Admin | john@example.com | 1234567890 |

Scenario: Delete last added user
  Then user clicks on x button to delete the user
  And user verifies that user is deleted