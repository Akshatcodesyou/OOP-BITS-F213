import java.util.Scanner;

public class MinMaxAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no. of floating numbers");
        int n=scanner.nextInt();
        double[] nums = new double[n]; 
        for(int i = 0; i<nums.length; i++){
            nums[i] = scanner.nextDouble();
        }
        double min = nums[0];
        double max = nums[0];
        double avg = 0;
        for(int i = 1; i<nums.length; i++){
            if( nums[i] > max){
                max=nums[i];
            }
            else{
                min = nums[i];
            }
        }
        double sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum = sum + nums[i];
        }
        avg = sum/nums.length;
        System.out.println("Max is " + max);
        System.out.println("Min is " + min);
        System.out.println("Avg is " + avg);
        scanner.close();
    }
}
