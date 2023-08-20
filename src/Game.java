import java.util.Scanner;
public class Game {
    Scanner sc = new Scanner(System.in);
    private int[] array;
    private final String name;
    private int spot;
    private int num = 0;

    public Game(String playerName) {
        this.array = new int[10];
        for (int i : this.array) {
            array[i] = 0;
        }
        this.name = playerName;
    }

    public void generateNum() {
        while (!checkNums()) {
            this.num = (int) (Math.random() * 1000);
        }
    }

    public boolean checkNums() {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == this.num) {
                return false;
            }
        }
        return true;
    }

    public void setSpot() {
        System.out.println("Pick an empty spot to place your number. 1-10 only.");
        this.spot = sc.nextInt() - 1;
    }
    public void insertNum() {
        this.array[this.spot] = this.num;
    }

    public void numPlace() {
        boolean placed = false;
        while (!placed) {
            setSpot();
            if (array[this.spot] != 0) {
                System.out.println("Spot is already occupied. Choose another.");
            } else {
                insertNum();
                placed = true;
            }
        }
    }

    public boolean validMove() {
        if ((this.spot != 0 && this.array[this.spot - 1] != 0 && this.num < this.array[this.spot - 1])
                || (this.spot != this.array.length-1 && this.array[this.spot + 1] != 0 && this.num > this.array[this.spot + 1])) {
            return false;
        }
        return true;
    }

    public void win() {
        System.out.println("You won the game! All of the numbers are in ascending order!");
        printCurrentList();
    }

    public void printCurrentList() {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == 0) {
                System.out.println((i+1) + ". ");
            } else {
                System.out.println((i+1) + ". " + this.array[i]);
            }
        }
    }

    public void playGame() {
        System.out.println("The rules are simple: place the numbers in ascending order! Try not to misplace any...");
        System.out.println("Game has started! Good luck, " + this.name);

        for(int i = 0; i < this.array.length; i++) {
            generateNum();
            System.out.printf("The number is %d\n", this.num);
            printCurrentList();
            numPlace();
            if (!validMove()) {
                System.out.println("Game over!");
                break;
            }
        }
        win();
    }
}
