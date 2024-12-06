Feature: Bowling Game Scorer
  As a bowling player
  I want to calculate my score accurately
  So that I can track my performance

  Scenario: All Strikes
    Given a new bowling game
    When I roll 12 times with 10 pins each
    Then the score should be 300

  Scenario: All Spares
    Given a new bowling game
    When I roll 10 frames with 5 pins each for both rolls
    And I roll 5 pins as the bonus roll
    Then the score should be 150

  Scenario: No Strikes or Spares
    Given a new bowling game
    When I roll 10 frames with 3 and 4 pins alternately
    Then the score should be 70

  Scenario: Mixed Game
    Given a new bowling game
    When I roll a strike
    And I roll 7 and 3 for the next frame (a spare)
    And I roll 4 and 5 for the next frame
    And I roll 12 times with 0 pins each for the remaining rolls
    Then the score should be 43