
package org.example;

import io.cucumber.java.en.*;
import io.cucumber.junit.platform.engine.Constants;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/koushick/BDD/Steps")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/java/org/example/bowling_scorer.feature")
public class BowlingScorerSteps {

   private BowlingScorer scorer;

   @Given("a new bowling game")
   public void a_new_bowling_game() {
      scorer = new BowlingScorer();
   }

   @When("I roll {int} times with {int} pins each")
   public void i_roll_times_with_pins_each(int rolls, int pins) {
      for (int i = 0; i < rolls; i++) {
         scorer.roll(pins);
      }
   }

   @When("I roll {int} frames with {int} pins each for both rolls")
   public void i_roll_frames_with_pins_each_for_both_rolls(int frames, int pins) {
      for (int i = 0; i < frames; i++) {
         scorer.roll(pins);
         scorer.roll(pins);
      }
   }

   @When("I roll {int} pins as the bonus roll")
   public void i_roll_pins_as_the_bonus_roll(int pins) {
      scorer.roll(pins);
   }

   @When("I roll {int} frames with {int} and {int} pins alternately")
   public void i_roll_frames_with_and_pins_alternately(int frames, int pins1, int pins2) {
      for (int i = 0; i < frames; i++) {
         scorer.roll(pins1);
         scorer.roll(pins2);
      }
   }

   @When("I roll a strike")
   public void i_roll_a_strike() {
      scorer.roll(10);
   }

   @When("I roll {int} and {int} for the next frame \\(a spare)")
   public void i_roll_and_for_the_next_frame_a_spare(int pins1, int pins2) {
      scorer.roll(pins1);
      scorer.roll(pins2);
   }

   @When("I roll {int} and {int} for the next frame")
   public void i_roll_and_for_the_next_frame(int pins1, int pins2) {
      scorer.roll(pins1);
      scorer.roll(pins2);
   }

   @When("I roll {int} times with {int} pins each for the remaining rolls")
   public void i_roll_times_with_pins_each_for_the_remaining_rolls(int rolls, int pins) {
      for (int i = 0; i < rolls; i++) {
         scorer.roll(pins);
      }
   }

   @Then("the score should be {int}")
   public void the_score_should_be(int expectedScore) {
      assertEquals(expectedScore, scorer.getScore());
   }
}
