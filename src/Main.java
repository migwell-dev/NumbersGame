import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void chooseGame() {
        System.out.println("Good day!");
        System.out.println("What game do you want to play?");
        System.out.println("1.Numbers Game\n2.Sudoku");
        int a = sc.nextInt();
        switch(a) {
            case 1:
                Game myGame = new Game();
                myGame.playGame();
                break;
            case 2:
                 Sudoku newGame = new Sudoku();
                 newGame.playGame();
                 break;
            default:
                 System.out.println("Game not found...");
            }
    }
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("Exit(0) or play(1)?");
            int response = sc.nextInt();
            switch (response) {
                case 0:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                case 1:
                    chooseGame();
                    break;
                default:
                    System.out.println("Response not recognized...");
            }

        }
    }
}