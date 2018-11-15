import java.util.*;
public class BattleShips {
   public static String[][]sea = new String[10][10];
   public  static  int userShips = 5;
   public static  int compShips = 5;
    public static void main(String[] args) {
        intro();
        map(sea);
        display(sea);
        deployPlayerShips(sea);
        deployComputerShips(sea);
        battle(sea, userShips, compShips);

    }

    public static void intro() {
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println();
        System.out.println("Right now the sea is empty.");
        System.out.println();
    }

    public static void map (String[][] sea) {
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[0].length; j++) {
                sea[i][j] = " ";

            }
        }
    }


    public static void display(String[][] sea) {
        System.out.println("   0123456789   ");
        for (int row = 0; row < sea.length; row++) {
            System.out.print(row + " |");
            for(int col = 0; col < sea[0].length; col++) {
                if (sea[row][col] == "2") {
                    sea[row][col] = " ";
                }
                System.out.print(sea[row][col]);
            }
            System.out.println("| " + row);
        }
        System.out.println("   0123456789   ");
        System.out.println();
    }


    public static void deployPlayerShips(String[][] sea) {
        Scanner input = new Scanner(System.in);
        System.out.println("Deploy your ships.");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter X coordinate for your " + i + ". ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + ". ship: ");
            int y = input.nextInt();
            while (x < 0 || x > 9 || y < 0 || y > 9 || sea[x][y].equals("@")) {
                System.out.println("Invalid Coordinates or Already Occupied.");
                System.out.print("Enter X coordinate for your " + i + ". ship: ");
                x = input.nextInt();
                System.out.print("Enter Y coordinate for your " + i + ". ship: ");
                y = input.nextInt();
            }
            sea[x][y] = "@";
        }
        display(sea);

    }

    public  static void deployComputerShips (String[][] sea) {
        Random rand = new Random();
        System.out.println("Computer is deploying ships.");

        for (int i = 1; i <= 5; i++) {
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            while (sea[x][y].equals("2") || sea[x][y].equals("@")) {
                x = rand.nextInt(10);
                y = rand.nextInt(10);
            }
            System.out.println(i + ". ship DEPLOYED.");
            sea[x][y] = "2";
        }
    }

    public static void battle (String[][] sea, int userShips, int compShips) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        for (;;) {
            System.out.println("YOUR TURN");
            System.out.print("Enter X coordinate: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            int y = input.nextInt();
            while (x < 0 || x > 9 || y < 0 || y > 9 || sea[x][y].equals("-") || sea[x][y].equals("!") || sea[x][y].equals("x")) {
                System.out.println("Invalid Coordinates or Already Occupied.");
                System.out.print("Enter valid X coordinate: ");
                x = input.nextInt();
                System.out.print("Enter valid Y coordinate: ");
                y = input.nextInt();
            }
            if (sea[x][y] == "2") {
             System.out.println("Boom! You sunk the ship!");
                sea[x][y] = "!";
                compShips--;
            } else if (sea[x][y] == "@") {
                System.out.println("Oh no, you sunk your own ship.");
                sea[x][y] = "x";
                userShips--;
            } else {
                System.out.println("Sorry, you missed.");
                sea[x][y] = "-";
            }
            System.out.println("COMPUTER'S TURN");
            int x1 = rand.nextInt(10);
            int y1 = rand.nextInt(10);
            while (x1 < 0 || x1 > 9 || y1 < 0 || y1 > 9 || sea[x1][y1].equals("-") || sea[x1][y1].equals("!") || sea[x1][y1].equals("x") || sea[x1][y1] == sea[x][y]) {
                x1 = rand.nextInt();
                y1 = rand.nextInt();
            }
            if (sea[x1][y1] == "@") {
                System.out.println("The Computer sunk one of your ships!");
                sea[x1][y1] = "x";
                userShips--;
            } else if (sea[x1][y1] == "2") {
                System.out.println("The Computer sunk one of its own ships.");
                sea[x1][y1] = "!";
                compShips--;
            } else {
                System.out.println("Computer missed.");
            }
            display(sea);
            System.out.println("Your ships: " + userShips + " | Computer ships: " + compShips);
            gameOver(userShips, compShips);
            System.out.println("--------------------------------------------------");

            if (userShips == 0 || compShips == 0) {
                break;
            }
        }
    }

    public static void gameOver (int userShips, int compShips) {
        if (userShips == 0) {
            System.out.println("Oh no! You lose the battle.");
        }
        if (compShips == 0) {
            System.out.println("Hooray! You win the battle.");
        }
    }
}
