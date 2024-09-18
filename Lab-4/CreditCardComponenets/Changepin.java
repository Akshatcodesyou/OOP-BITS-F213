import java.util.Scanner;
class CreditCard {
    private int pin;

    public CreditCard(int pin){
        this.pin = pin;
    }

    public void changepin(int newPin){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the old pin: ");
        int confirmpin = scanner.nextInt();
        if(confirmpin == pin){
            System.out.print("Enter new pin: ");
            pin = scanner.nextInt();
            System.out.print("Pin change successful! ");
        } else {
            System.out.println("Incorrect old pin.");
        }
        scanner.close();
    }
    public int getPin() {
        return pin;
    }
}
public class changepin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Set your pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine();
        CreditCard card = new CreditCard(pin);

        System.out.println("Your pin is " + card.getPin());
        
        card.changepin(pin);

        System.out.print("Your pin is " + card.getPin());
        scanner.close();
    }

}

