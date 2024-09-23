import java.util.Scanner;
class Area {
    private float side1;
    private float side2;
    private int side;
    private float radius;

    public int calc_Area(int side){
        this.side = side;
        return side * side;
    }

    public double calc_Area(float radius){
        this.radius = radius;
        return 3.14*radius*radius;
    }

    public double calc_Area(float side1, float side2){
        this.side1 = side1;
        this.side2 = side2;
        return side1*side2;
    }

    public void display(){
        
    }
}
public class AreaTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which area do you want to calculate? \n (1) Square \n (2) Circle \n (3) Rectangle");
        int opt = scanner.nextInt();
        switch (opt) {
            case 1:
                System.out.println("Enter the side of the square: ");
                int side = scanner.nextInt();
                Area areas = new Area();
                int squareArea = areas.calc_Area(side);
                System.out.println("The area of the square is: " + squareArea);
                break;
            case 2: 
                System.out.println("Enter the radius of the circle: ");
                float radius = scanner.nextFloat();
                Area areac = new Area();
                double circleArea = areac.calc_Area(radius);
                System.out.println("The area of the circle is: " + circleArea);
            case 3:
                System.out.println("Enter the both sides of the rectangle: ");
                float side1 = scanner.nextFloat();
                float side2 = scanner.nextFloat();
                Area arear = new Area();
                double rectangleArea = arear.calc_Area(side1, side2);
                System.out.println("The area of the circle is: " + rectangleArea);
            default:
                break;
        }
        scanner.close();
    }
}
