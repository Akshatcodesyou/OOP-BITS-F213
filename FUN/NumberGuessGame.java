import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Numberguessgame {
    String name;
    int num;

    public Numberguessgame(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public static int mainNum;

    static {
        mainNum = (int) (Math.random() * 10);
    }

    // ANSI escape codes for colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Numberguessgame[] players = new Numberguessgame[3];

        for (int i = 0; i < players.length; i++) {
            System.out.print(ANSI_CYAN + "Enter the name for player " + (i + 1) + ": " + ANSI_RESET);
            String name = scanner.nextLine();
            players[i] = new Numberguessgame(name, 0);

            System.out.print(ANSI_YELLOW + "Guess a number between 0-9 " + players[i].name + ": " + ANSI_RESET);
            int num = scanner.nextInt();
            scanner.nextLine();
            players[i] = new Numberguessgame(name, num);

            // Short pause for effect
            TimeUnit.SECONDS.sleep(1);
        }

        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getNum() == mainNum) {
                System.out.println(ANSI_GREEN + players[i].getName() + " wins!" + ANSI_RESET);
                count++;
            }
        }

        if (count == 0) {
            System.out.println(ANSI_RED + "\nNo one wins!" + ANSI_RESET);
        } else if (count == 3) {
            System.out.println(ANSI_GREEN + "\nEveryone wins!" + ANSI_RESET);
        }

        System.out.println(ANSI_BLUE + "Winning Number: " + mainNum + ANSI_RESET);

        System.out.println(ANSI_BOLD + "\nPlayer Details:" + ANSI_RESET);
        for (int i = 0; i < players.length; i++) {
            System.out.println(ANSI_CYAN + "Name = " + players[i].getName() + ", Number = " + players[i].getNum() + ANSI_RESET);
        }

        scanner.close();
    }
}
