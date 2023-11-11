Feature: Manage forums of artists
  Scenario: Edit Forum
    Given the artist is in the Fanatic Forum section
    And clicks on the View Your Forums button
    And clicks on the button with the pencil icon
    When completes the new data
    And clicks on Save
    Then a message will appear indicating that their forum has been saved.

  Scenario: Delete Forum
    Given that the artist is in the Fanatic Forum section
    And clicks on the View Your Forums button
    And clicks on the button with the trash can icon
    When revisits the Fanatic Forum section
    Then the deleted forum will not appear.