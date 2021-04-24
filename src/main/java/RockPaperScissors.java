import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

  private static int rounds;
  private static Map<Integer, String> possibleChoices = new HashMap<Integer, String>();
  private static int wins = 0;
  private static int losses = 0;

  public static void main(String[] args) {
    initializeHashMap();
    rounds = handshake();
    play();
    if(wins > losses) {
      System.out.println("You won the game");
    } else {
      System.out.println("You lost the game");
    }
  }

  public static void play() {
    for (int i = 0; i < rounds; i++) {
      System.out.println();
      System.out.println("Round number " + (i + 1) + " out of " + rounds);
      Scanner scan = new Scanner(System.in);
      System.out.println("Choose a number 1 - rock, 2 - paper, 3 - scissors");
      int userChoice = 0;
      do {
        try {
          userChoice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("Please choose a number");
          continue;
        }

      } while(userChoice != 1 && userChoice != 2 && userChoice != 3);
      System.out.println("You chose " + possibleChoices.get(userChoice));
      determineDefeat(userChoice);
      if (checkGameOver()) {
        break;
      }
    }
  }

  public static void determineDefeat(int userChoice) {
    loop: while (true) {
      Random rand = new Random();
      int computerChoice = rand.nextInt(3) + 1;

      switch(userChoice) {
        case 1:
          if (computerChoice == 3) {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("You win this round");
            wins++;
            break loop;
          } else if(computerChoice == 2) {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("You lose this round");
            losses++;
            break loop;
          } else {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("Tie, repeat round");
            break;
          }
        case 2:
          if (computerChoice == 1) {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("You win this round");
            wins++;
            break loop;
          } else if(computerChoice == 3) {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("You lose this round");
            losses++;
            break loop;
          } else {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("Tie, repeat round");
            break;
          }
        case 3:
          if (computerChoice == 2) {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("You win this round");
            wins++;
            break loop;
          } else if(computerChoice == 1) {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("You lose this round");
            losses++;
            break loop;
          } else {
            System.out.println("Computer chose " + possibleChoices.get(computerChoice));
            System.out.println("Tie, repeat round");
            break;
          }
      }
    }
  }
  public static boolean checkGameOver() {
    return wins >= Math.ceil(rounds/2.0) || losses >= Math.ceil(rounds/2.0);
  }

  public static void initializeHashMap() {
    possibleChoices.put(1, "rock");
    possibleChoices.put(2, "paper");
    possibleChoices.put(3, "scissors");
  }

  public static int handshake() {
    int rounds = 0;
    Scanner scan = new Scanner(System.in);
    System.out.println("Out of how many games do you want to play? Choose odd number");
    do {
      try {
        rounds = Integer.parseInt(scan.nextLine());
      } catch(NumberFormatException e) {
        System.out.println("Please choose an odd number");
        continue;
      }

    } while(rounds % 2 == 0);

    return rounds;
  }
}
