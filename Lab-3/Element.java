//Please scroll below to see which code you may want as I have written different methods for the same problem

// using method shown in class without directly making an array 
import java.util.Scanner;

public class Element {
    int atnum;
    String atname;
    String atsymbol;
    double atweight;

    Element(int atnum, String atname, String atsymbol, double atweight) {
        this.atnum = atnum;
        this.atname = atname;
        this.atsymbol = atsymbol;
        this.atweight = atweight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Element hydrogen = new Element(1, "Hydrogen", "H",1.008 );
        Element scandium = new Element(1, "Scandium", "Sc", 44.9596);
        Element chromium = new Element(24, "Chromium", "Cr", 51.9961);

        Element[] elements = {hydrogen, scandium, chromium};

        System.out.print("Only print elements above atomic weight 15? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("y")) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].atweight > 15) {
                    System.out.println("Element: " + elements[i].atname + " " + elements[i].atsymbol + " " + elements[i].atweight);
                }
            }
        } else if (input.equals("n")) {
            for (int i = 0; i < elements.length; i++) {
                System.out.println("Element: " + elements[i].atname + " " + elements[i].atsymbol + " " + elements[i].atweight);
            }
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }

        scanner.close();
    }
}

        scanner.close();
    }
}


