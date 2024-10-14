import java.util.Scanner;
public class PrintTable {
    public void printTable(int n){
        for(int i = 1; i<= 10; i++){
            System.out.println(n + " x " + i + " = " + n*i);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to print its table: ");
        int n = scanner.nextInt();
        PrintTable table = new PrintTable();
        table.printTable(n);
        scanner.close();
    }
}
