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
    public static double highestprice(Car[] showroom){
        double highest = showroom[0].calc_grand_total();
        int x = 0;
        for(int i = 1; i < showroom.length; i++){
            if(showroom[i].calc_grand_total() > highest){
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
            new Car(50000, 5000, 3000, "Land Cruiser"),
            new Car(60000, 6000, 4000, "Lexus LX600"),
            new Car(70000, 7000, 5000, "Range Rover Sport"),
            new Car(55000, 5500, 3500, "Nissan Patrol"),
            new Car(45000, 4500, 2500, "Ford Everest")
        };

        System.out.println("Welcome to Grand Cars UAE!");
        System.out.println("We have the following cars available to be yours: ");
        boolean x = true;

        while (x) {
            for (int i = 0; i < showroom.length; i++) {
                System.out.println((i + 1) + " " + showroom[i].Vehicle_id);
            }

            System.out.println("Select one of the cars to see their specifications: ");
            int opt = scanner.nextInt();

            scanner.nextLine();

            switch (opt) {
                case 1:
                    showroom[0].showCar();
                    break;
                case 2:
                    showroom[1].showCar();
                    break;
                case 3:
                    showroom[2].showCar();
                    break;
                case 4:
                    showroom[3].showCar();
                    break;
                case 5:
                    showroom[4].showCar();
                    break;
                default:
                    System.out.println("Invalid Option! Please enter a valid option: ");
                    continue;
            }

            System.out.println("Calculate Total Price? (y/n): ");
            String opt2 = scanner.nextLine().toLowerCase();

            if (opt2.equals("y")) {
                System.out.println("Total Price: " + showroom[opt - 1].calc_total());
                System.out.println("Grand Total (after discount): " + showroom[opt - 1].calc_grand_total());
            } else {
                System.out.println("Thank you for browsing!");
            }

            System.out.println("Do you want to select another car? (y/n): ");
            String continueBrowsing = scanner.nextLine().toLowerCase();
            if (!continueBrowsing.equals("y")) {
                x = false;
            }
        }
        System.out.println("Highest Priced car");
        highestprice(showroom);
        scanner.close();
    }
}
