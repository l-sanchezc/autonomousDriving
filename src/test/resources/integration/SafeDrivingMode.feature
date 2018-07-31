Feature: Test SAFE driving mode implementation

  Scenario: SUCCESS
    Given A vehicle with SaFE driving mode
    When I have the following sensor events: 50,1,3,2,4,5,20,15,6
    Then The vehicle speed is 25

  Scenario: IGNORE
    Given A vehicle with safe driving mode
    When I have the following sensor events: 6,6,10,10,1,1,4,4
    Then The vehicle speed is 10

  Scenario: INVALID
    Given A vehicle with SAFE driving mode
    When I have the following sensor events: 80,200,101,-1,0,7
    Then The vehicle speed is 85
