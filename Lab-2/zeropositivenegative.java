// import java.util.Scanner;

// public class zeropositivenegative {
//     public static void main(String[] args) {
//         int num[] = new int[5];
//         int positive = 0, negative = 0, zero = 0;

//         Scanner inp = new Scanner(System.in);

//         for(int i = 1; i <= 5; i++) {
//             if(i==1){
//             System.out.println("Enter " + (i) + "st number: ");
//         }
//         else if(i==2){
//             System.out.println("Enter " + (i) + "st number: ");
//         }
//         else if(i==3){
//             System.out.println("Enter " + (i) + "st number: ");
//         }
//             else{
//             System.out.println("Enter " + (i) + "st number: ");
//         }
//             num[i] = inp.nextInt();
            
//             if(num[i] > 0) {
//                 positive++;
//             } else if(num[i] < 0) {
//                 negative++;
//             } else {
//                 zero++;
//             }
//         }
//         inp.close();
        
//         System.out.println("Zeros: " + zero + " Positives: " + positive + " Negatives: " + negative);
//     }
// }

import java.util.Scanner;

public class zeropositivenegative {
    public static void main(String[] args) {
        int num[] = new int[5];
        int positive = 0, negative = 0, zero = 0;

        Scanner inp = new Scanner(System.in);

        for (int i = 0; i < 5; i++) { // Change from i = 1 to i = 0
            // Determine the correct suffix for the input prompt
            String suffix;
            switch (i + 1) {
                case 1: suffix = "st"; break;
                case 2: suffix = "nd"; break;
                case 3: suffix = "rd"; break;
                default: suffix = "th"; break;
            }
            System.out.println("Enter " + (i + 1) + suffix + " number: ");
            
            num[i] = inp.nextInt();
            
            if (num[i] > 0) {
                positive++;
            } else if (num[i] < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        inp.close();
        
        System.out.println("Zeros: " + zero + " Positives: " + positive + " Negatives: " + negative);
    }
}
