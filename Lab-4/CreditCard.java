import java.util.Scanner;

class CreditCard {
    private String name;
    private long cardNo;
    private boolean enabled;
    private int pin;
    private String expiryMonth;
    private int cardType;
    private int currentCredit;
    private int CreditLimit;

    public CreditCard(Scanner scanner) {

        System.out.print("Enter name for card holder: ");
        this.name = scanner.nextLine();

        this.cardNo = (long) (Math.random() * 10000000000000000L);
        this.enabled = true;

        this.pin = pinValid(scanner);

        this.expiryMonth = "December";

        System.out.print("Which card would you like to opt for? \n Silver (1) \n Gold (2) \n Platinum (3) \n Option: ");
        this.cardType = scanner.nextInt();
        while (cardType < 1 || cardType > 3) {
            System.out.print("Invalid option! Please select a valid card type (1-3): ");
            this.cardType = scanner.nextInt();
        }

        this.currentCredit = 0;
        this.CreditLimit = CreditLimit(cardType);

        System.out.println("Current credit: " + currentCredit);

        System.out.print("Would you like to add credit (y/n): ");
        scanner.nextLine();
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("y")) {
            System.out.print("Enter amount to be added: ");
            this.currentCredit += scanner.nextInt();
            System.out.println("Money added! Current credit: " + currentCredit);
        } else {
            System.out.println("Ok! current credit: " + currentCredit);
        }
    }

    public int pinValid(Scanner scanner) {
        int pin;
        while (true) {
            System.out.print("Set a pin for your card (4 digits): ");
            pin = scanner.nextInt();
            if (pin >= 1000 && pin <= 9999) {
                break;
            }
            System.out.println("Error! Pin must be a 4-digit number.");
        }
        return pin;
    }

    public int CreditLimit(int cardType) {
        switch (cardType) {
            case 3:
                return 50000;
            case 2:
                return 25000;
            default:
                return 10000;
        }
    }

    public void changepin(int newPin, Scanner scanner) {
        System.out.print("Enter the old pin: ");
        int confirmpin = scanner.nextInt();
        if (confirmpin == pin) {
            this.pin = newPin;
            System.out.println("Pin change successful!");
        } else {
            System.out.println("Incorrect old pin.");
        }
    }

    public int getPin() {
        return pin;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void display() {
        System.out.println("Card Holder: " + name);
        System.out.println("Card Number: " + cardNo);
        System.out.println("Card Type: " + (cardType == 1 ? "Silver" : cardType == 2 ? "Gold" : "Platinum"));
        System.out.println("Current Credit: " + currentCredit);
        System.out.println("Credit Limit: " + CreditLimit);
        System.out.println("Enabled: " + enabled);
    }

    public void transact(Scanner scanner){
        System.out.println("Enter pin: ");
        int temppin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter amount to be transferred: ");
        int amnt = scanner.nextInt();
        scanner.nextLine();
        if(enabled && temppin == pin && amnt <= CreditLimit){
            System.out.println("Transaction successful, " + amnt + "transferred! " + "Remaining credit: " + (currentCredit-amnt));
        }
        scanner.close();
    }
        public void changeCardStatus(boolean enabled){
            Scanner scanner = new Scanner(System.in);
            if(enabled == true){
            System.out.println("Want to disable card? (y/n): ");
            scanner.nextLine();
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "y":
                    enabled = false;
                    break;
                case "n":
                    enabled = true;
                default:
                    System.out.println("Invalid Input! ");
                    break;
            }
            }
            else{
                System.out.println("Want to enable card? (y/n): ");
            scanner.nextLine();
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "y":
                    enabled = true;
                    break;
                case "n":
                    enabled = false;
                default:
                    System.out.println("Invalid Input! ");
                    break;
            }
            }

        scanner.close();
        }
}

public class CreditCardTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a new Credit Card...");
        CreditCard myCard = new CreditCard(scanner);
        System.out.println("Card created for: " + myCard.getCardNo());
        myCard.display();
        myCard.transact(scanner);
        myCard.changeCardStatus(true);
        scanner.close(); 
    }
}
