import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        boolean[] counted = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (counted[i]) continue;
            
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    counted[j] = true;
                }
            }
            
            if (count > 1) {
                System.out.println("Duplicate of " + arr[i] + ": " + count);
            }
        }

        scanner.close();
    }
}
