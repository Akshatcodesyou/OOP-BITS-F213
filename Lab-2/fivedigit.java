import java.util.Scanner;
public class fivedigit {
    public static void main(String[] args) {
        int num;
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter a 5 digit number: ");
        num = inp.nextInt();
        System.out.println("The number is: "+num);
        int num1 = 10000;
        for(int i=0; i<5; i++){
            System.out.println(" "+num/num1);
            num = num%num1;
            num1 = num1/10;
        }
    }
}
