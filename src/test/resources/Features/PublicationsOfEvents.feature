Feature: Publications Of Events
  Scenario: Correct publication of events
    Given that the artist is on Event section
    When press the button Post Event
    And fill in the data correctly
    And press the button Create and Post
    Then an event will be created successfully
  Scenario: Incorrect publication of events
    Given that the artist is on Event section
    When press the button Post Event
    And do not fill in the form
    And press the button Create and Post
    Then the event will not be created
