import java.util.*;
public class BattleShips {
    public static void main(String[] args) {
        String[][]sea = new String[10][10];
        intro();
        map(sea);
        deployPlayerShips(sea);

    }

    public static void intro() {
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println();
        System.out.println("Right now the sea is empty.");
        System.out.println();
    }


    public static void map(String[][] sea) {
        System.out.println("   0123456789   ");
        for (int row = 0; row < sea.length; row++) {
            System.out.print(row + " |");
            for(int col = 0; col < sea[0].length; col++) {
                sea[row][col] = " ";
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
        map(sea);
    }


}
