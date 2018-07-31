Feature: Test NORMAL driving mode implementation

  Scenario: SUCCESS
    Given A vehicle with NorMAl driving mode
    When I have the following sensor events: 7,50,1,3,2,5,4,6,7
    Then The vehicle speed is 70

  Scenario: IGNORE
    Given A vehicle with normal driving mode
    When I have the following sensor events: 7,3,1,3,7,1,2,2
    Then The vehicle speed is 35

  Scenario: INVALID
    Given A vehicle with NORMAL driving mode
    When I have the following sensor events: 7,-7,60,0,101,7,1000,-5
    Then The vehicle speed is 80