Feature: Artist Album Creation
  Scenario: successful album creation
    Given that the artist is on Event section
    And click the Add Album button
    When the data is completed correctly
    And click Create Album
    Then the album will be created correctly.
  Scenario: poor Album creation
    Given that the artist is on Event section
    And click the Add Album button
    When you fill out the album data
    And click Create Album
    Then a message will appear, your album already exists.