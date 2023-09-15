Feature: Creation of fan forum
  Scenario: Creation of correct Forum
    Given the fanatic is in the Fanatic Forum section
    And press the button to create forum
    When complete the data correctly
    And press on Create
    Then message from your forum created successfully will appear

