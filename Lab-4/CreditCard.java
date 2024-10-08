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
    public void CheckPin(int temppin){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter pin: ");
        temppin = scanner.nextInt();
        scanner.nextLine();
        if(temppin == pin){
            System.out.println("Authentication confirmed. ");
        }
        else{
            System.out.println("Error!");
        }
        scanner.close();
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
        if(temppin == pin){
        System.out.println("Enter amount to be transferred: ");
        int amnt = scanner.nextInt();
        scanner.nextLine();
        if(enabled && amnt <= CreditLimit && amnt <= currentCredit){
            System.out.println("Transaction successful, \n" + amnt + " transferred! \n" + "Remaining credit: " + (currentCredit-amnt));
        }
        else if(amnt >= currentCredit){
            System.out.println("Insufficient funds! ");
        }
        else{
            System.out.println("Error! please check if your card status is enabled and amount entered is less than your CreditLimit! ");
        }
        }
        else{
            System.out.println("Wrong pin! ");
        }
    }
        public void changeCardStatus(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enable or disable card? (e/d): ");
                String input = scanner.nextLine().trim().toLowerCase();
                if(input.equals("e")){
                    if(enabled == true){
                        System.out.println("Card already enabled! ");
                    }
                    else if(enabled == false){
                        enabled = true;
                        System.out.println("Card is now enabled! ");
                    }
                    else{
                        System.out.println("ERROR404 ");
                    }
                }
                else if(input.equals("d")){
                    if(enabled == false){
                        System.out.println("Card already disabled! ");
                    }
                    else if(enabled == true){
                        enabled = false;
                        System.out.println("Card is now disabled! ");
                    }
                    else{
                        System.out.println("ERROR404 ");
                    }
                }
                else{
                    System.out.println("Invalid input! ");
                }
        }
}
public class CreditCardTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a new Credit Card...");
        CreditCard myCard = new CreditCard(scanner);
        System.out.println("Card created for: " + myCard.getCardNo());
        boolean exit = false;
        while (!exit) {
            System.out.print("Display card info? (1) \nTransfer money? (2) \nDisable/enable card? (3) \nExit (4): ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    myCard.display();
                    break;
                case 2:
                    myCard.transact(scanner);
                    break;
                case 3:
                    myCard.changeCardStatus();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input! ");
                    break;
            }
        }
        scanner.close();
    }
}


