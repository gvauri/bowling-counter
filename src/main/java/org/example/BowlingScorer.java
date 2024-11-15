package org.example;

import java.util.Scanner;

public class BowlingScorer {
   private static final int FRAMES = 10;
   private int[] rolls = new int[21];
   private int currentRoll = 0;

   public void roll(int pins) {
      rolls[currentRoll++] = pins;
   }

   public int getScore() {
      int score = 0;
      int rollIndex = 0;

      for (int frame = 0; frame < FRAMES; frame++) {
         if (isStrike(rollIndex)) { // Strike
            score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
            rollIndex += 1;
         } else if (isSpare(rollIndex)) { // Spare
            score += 10 + rolls[rollIndex + 2];
            rollIndex += 2;
         } else { // Normaler Wurf
            score += rolls[rollIndex] + rolls[rollIndex + 1];
            rollIndex += 2;
         }
      }
      return score;
   }

   private boolean isStrike(int rollIndex) {
      return rolls[rollIndex] == 10;
   }

   private boolean isSpare(int rollIndex) {
      return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
   }

   public static void main(String[] args) {
      BowlingScorer scorer = new BowlingScorer();
      Scanner scanner = new Scanner(System.in);

      System.out.println("Bowling Spiel gestartet. Bitte geben Sie die Anzahl der umgeworfenen Pins ein:");

      for (int frame = 1; frame <= FRAMES; frame++) {
         System.out.println("Frame " + frame + ":");
         int firstRoll = scanner.nextInt();
         scorer.roll(firstRoll);

         if (firstRoll < 10) {
            int secondRoll = scanner.nextInt();
            scorer.roll(secondRoll);
         }

         System.out.println("Aktuelle Punktzahl: " + scorer.getScore());
      }

      System.out.println("Endpunktzahl: " + scorer.getScore());
      scanner.close();
   }
}
