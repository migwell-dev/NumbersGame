import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
    Scanner sc = new Scanner(System.in);
    private int[][] solution = {{1,2,3},
                                {2,3,1},
                                {3,1,2}};
    private int[][] board;
    public int row;
    public int col;

    public Sudoku() {
        this.board = new int[3][3];
    }

    public void generateBoard() {
        //generate board, randomly choose 1 space to reveal, place X on every other space
        System.out.println("Generating board...");
        for(int i = 0; i < this.solution.length; i++) {
            boolean revealed = false;
            for(int j = 0; j < this.solution[i].length; j++) {
                if (!revealed) {
                    if (Math.random() > 0.5 || j == this.solution[i].length-1) {
                        System.out.print(this.solution[i][j]);
                        this.board[i][j] = this.solution[i][j];
                        revealed = true;
                    } else {
                        System.out.print("X");
                    }
                } else {
                    System.out.print("X");
                }

            }
            System.out.println();
        }
    }

    public boolean validSpot() {
        return this.board[this.row][this.col] == 0;
    }

    public void placeNum() {
        boolean placed = false;
        while (!placed) {
            getCoords();
            if (validSpot()) {
                System.out.println("Space is available, input a number to place (1-3)");
                int num = sc.nextInt();
                this.board[this.row][this.col] = num;
                placed = true;
            } else {
                System.out.println("Space is not available, please input valid coordinates.");
            }
        }
    }

    public void getCoords() {
        System.out.println("Please input row: ");
        this.row = sc.nextInt() - 1;
        System.out.println("Please input column ");
        this.col = sc.nextInt() - 1;
    }

    public void getCurrentBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for(int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] == 0) {
                    System.out.print("X");
                } else {
                    System.out.print(this.board[i][j]);
                }
            }
            System.out.println();
        }
    }

    public boolean inPlay() {
        for(int i = 0; i < this.board.length; i++) {
            for(int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void lost() {
        System.out.println("Too bad! You missed a win! The board was\n");
        generateBoard();
    }

    public void win() {
        System.out.println("Congrats! You won the game!");
    }

    public void checkWin() {
        if (Arrays.deepEquals(board, solution)) {
            win();
        } else {
            lost();
        }
    }

    public void playGame() {
        System.out.println("The rules are simple! It's sudoku...");
        generateBoard();
        while (inPlay()) {
            placeNum();
            getCurrentBoard();
        }
        checkWin();
    }
}