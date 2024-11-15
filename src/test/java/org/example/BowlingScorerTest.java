package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BowlingScorerTest {

   @Test
   void testAllStrikes() {
      BowlingScorer scorer = new BowlingScorer();
      for (int i = 0; i < 12; i++) { // 12 Strikes für maximales Ergebnis
         scorer.roll(10);
      }
      assertEquals(300, scorer.getScore());
   }

   @Test
   void testAllSpares() {
      BowlingScorer scorer = new BowlingScorer();
      for (int i = 0; i < 10; i++) {
         scorer.roll(5);
         scorer.roll(5); // Spare
      }
      scorer.roll(5); // Zusätzlicher Wurf nach Spare im letzten Frame
      assertEquals(150, scorer.getScore());
   }

   @Test
   void testNoStrikesOrSpares() {
      BowlingScorer scorer = new BowlingScorer();
      for (int i = 0; i < 10; i++) {
         scorer.roll(3);
         scorer.roll(4); // 7 Punkte pro Frame
      }
      assertEquals(70, scorer.getScore());
   }

   @Test
   void testMixedGame() {
      BowlingScorer scorer = new BowlingScorer();
      scorer.roll(10); // Strike
      scorer.roll(7);
      scorer.roll(3); // Spare
      scorer.roll(4);
      scorer.roll(5);
      for (int i = 0; i < 12; i++) {
         scorer.roll(0);
      }
      assertEquals(43, scorer.getScore());
   }
}
