import java.util.Scanner;

class Election {
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] candidates = {'1', '2', '3', '4', '5'};
        int[] votes = {0, 0, 0, 0, 0};
        int vote_invalid = 0, vote_valid = 0;
        int flag = 1;

        // Welcome message
        System.out.println(GREEN + "Welcome to the Election Voting System!" + RESET);
        System.out.println(YELLOW + "=========================================" + RESET);

        do {
            System.out.println(BLUE + "Vote for the president: " + RESET);
            System.out.println(" (1) Candidate 1");
            System.out.println(" (2) Candidate 2");
            System.out.println(" (3) Candidate 3");
            System.out.println(" (4) Candidate 4");
            System.out.println(" (5) Candidate 5");
            System.out.println(" (6) Exit");
            System.out.print(YELLOW + "Please enter your vote (1-6): " + RESET);
            
            int vote = scanner.nextInt();
            switch (vote) {
                case 1:
                    votes[0]++;
                    vote_valid++;
                    break;
                case 2:
                    votes[1]++;
                    vote_valid++;
                    break;
                case 3:
                    votes[2]++;
                    vote_valid++;
                    break;
                case 4:
                    votes[3]++;
                    vote_valid++;
                    break;
                case 5:
                    votes[4]++;
                    vote_valid++;
                    break;
                case 6:
                    flag = 0;
                    break;
                default:
                    System.out.println(RED + "Invalid input. Please try again." + RESET);
                    vote_invalid++;
                    break;
            }
        } while (flag == 1);

        double max = votes[0];
        int index = 0;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > max) {
                max = votes[i];
                index = i;
            }
        }

        // Winner announcement with colors and ASCII art
        System.out.println(GREEN + "\n  ____      ____  _                                   ");
        System.out.println(" |_  _|    |_  _|(_)                                  ");
        System.out.println("   \\ \\  /\\  / /  __   _ .--.   _ .--.  .---.  _ .--.  ");
        System.out.println("    \\ \\/  \\/ /  [  | [ `.-. | [ `.-. |/ /__\\[ `/'`\\] ");
        System.out.println("     \\  /\\  /    | |  | | | |  | | | || \\__., | |     ");
        System.out.println("      \\/  \\/    [___][___||__][___||__]'.__.'[___]    " + RESET);

        System.out.println(BLUE + "The winner is candidate " + candidates[index] + 
                           " with a total of " + votes[index] + " votes." + RESET);
        System.out.println(BLUE + "Number of valid votes cast: " + vote_valid + RESET);
        
        scanner.close();
    }
}
