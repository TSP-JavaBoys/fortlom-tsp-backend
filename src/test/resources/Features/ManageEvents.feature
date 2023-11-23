Feature:Manage Events

  Scenario: Edit event
    Given the artist is in the “Events” section
    And click on the button with the “pencil” icon
    When you correctly complete the new data
    And click “Save”
    Then a message of your successful event will appear.
  Scenario: Delete event
    Given a artist is in the “Events” section
    And click on the button with the “trash can” icon
    When to check the “Events” section again
    Then the event you deleted will not appear.