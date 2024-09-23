import java.util.Scanner;
class Area {
    private float side1;
    private float side2;
    private int side;
    private float radius;
    private double Area;

    public void calc_Area(int side){
        this.side = side;
        this.Area =  side * side;
    }

    public void calc_Area(float radius){
        this.radius = radius;
        this.Area =  3.14*radius*radius;
    }

    public void calc_Area(float side1, float side2){
        this.side1 = side1;
        this.side2 = side2;
        this.Area =  side1*side2;
    }

    public void display(){
        System.out.println("Calculated area: " + Area);
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
                areas.calc_Area(side);
                areas.display();
                break;
            case 2: 
                System.out.println("Enter the radius of the circle: ");
                float radius = scanner.nextFloat();
                Area areac = new Area();
                areac.calc_Area(radius);
                areac.display();
            case 3:
                System.out.println("Enter the both sides of the rectangle: ");
                float side1 = scanner.nextFloat();
                float side2 = scanner.nextFloat();
                Area arear = new Area();
                arear.calc_Area(side1, side2);
                arear.display();
            default:
                break;
        }
        scanner.close();
    }
}
