Feature: Test SPORT driving mode implementation

  Scenario: SUCCESS
    Given A vehicle with SpOrT driving mode
    When I have the following sensor events: 20,1,3,30,4,2,7
    Then The vehicle speed is 75

  Scenario: IGNORE
    Given A vehicle with sport driving mode
    When I have the following sensor events: 7,7,3,3,1,1,2,2,4,4
    Then The vehicle speed is 50

  Scenario: INVALID
    Given A vehicle with SPORT driving mode
    When I have the following sensor events: 60,0,120,2,2,101,-1
    Then The vehicle speed is 65