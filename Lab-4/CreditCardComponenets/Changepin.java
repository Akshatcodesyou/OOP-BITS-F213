import java.util.Scanner;
class CreditCard {
    private int pin;

    public CreditCard(int pin){
        this.pin = pin;
    }

    public void changepin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the old pin");
        int confirmpin = scanner.nextInt();
        if(confirmpin == pin){
            System.out.println("Enter new pin: ");
            pin = scanner.nextInt();
            scanner.nextLine();
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

        System.out.println("Set your pin");
        int pin = scanner.nextInt();
        scanner.nextLine();
        CreditCard card = new CreditCard(pin);

        System.out.println("Your pin is " + pin);
        
        card.changepin();

        System.out.println("Your pin is " + card.getPin());
        scanner.close();
    }

}
