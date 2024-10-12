import java.util.Scanner;

public class Car {
    String Vehicle_id;
    float Base, ExerciseDuty, SalesTax;

    Car(float Base, float ExerciseDuty, float SalesTax, String Vehicle_id) {
        this.Base = Base;
        this.ExerciseDuty = ExerciseDuty;
        this.SalesTax = SalesTax;
        this.Vehicle_id = Vehicle_id;
    }

    public double calc_total() {
        return Base + ExerciseDuty + SalesTax;
    }

    public double calc_grand_total() {
        return (Base + ExerciseDuty + SalesTax) * 0.9;
    }

    public void showCar() {
        System.out.println("Car name: " + this.Vehicle_id);
        System.out.println("Base Price: " + this.Base);
        System.out.println("Exercise Duty: " + this.ExerciseDuty);
        System.out.println("Sales Tax: " + this.SalesTax);
    }

    public static double highestprice(Car[] showroom) {
        double highest = showroom[0].calc_grand_total();
        int x = 0;
        for (int i = 1; i < showroom.length; i++) {
            if (showroom[i].calc_grand_total() > highest) {
                highest = showroom[i].calc_grand_total();
                x = i;
            }
        }
        showroom[x].showCar();
        return highest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car[] showroom = new Car[]{
            new Car(250000, 10000, 2500, "Land Cruiser 2024"),
            new Car(510000, 10000, 5100, "Lexus LX600 2024"),
            new Car(500000, 10000, 5000, "Range Rover Sport 2024"),
            new Car(200000, 10000, 2000, "Nissan Patrol 2024"),
            new Car(170000, 10000, 1700, "Ford Everest 2024")
        };

        boolean running = true;
        
        while (running) {
            System.out.println("\nWelcome to Grand Cars UAE!");
            System.out.println("=================================");
            System.out.println("Please choose an option:");
            System.out.println("1. View Cars");
            System.out.println("2. See the Highest Priced Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Cars:");
                    for (int i = 0; i < showroom.length; i++) {
                        System.out.println((i + 1) + ". " + showroom[i].Vehicle_id);
                    }
                    System.out.print("\nSelect a car to see details: ");
                    int carChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (carChoice < 1 || carChoice > showroom.length) {
                        System.out.println("Invalid car choice! Please select a valid option.");
                    } else {
                        showroom[carChoice - 1].showCar();
                        System.out.print("Calculate Total Price? (y/n): ");
                        String calcChoice = scanner.nextLine().toLowerCase();
                        if (calcChoice.equals("y")) {
                            System.out.println("Total Price: " + showroom[carChoice - 1].calc_total());
                            System.out.println("Grand Total (after discount): " + showroom[carChoice - 1].calc_grand_total());
                        } else {
                            System.out.println("Thank you for browsing!");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nThe Highest Priced Car is:");
                    highestprice(showroom);
                    break;

                case 3:
                    System.out.println("Thank you for visiting Grand Cars UAE!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }

        scanner.close();
    }
}
