import java.util.Scanner;
import java.lang.*;

public class circle {
    public static void main(String[] args) {
        float radius, diameter, circumference, area;
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the radius of the circle: ");
        radius=inp.nextFloat();
        diameter=2*radius;
        circumference=(float) (2*Math.PI*radius);
        area=(float) (Math.PI*radius*radius);
        System.out.println("Diameter of the circle is: "+diameter);
        System.out.println("Circumference of the circle is: "+circumference);
        System.out.println("Area of the circle is: "+area);
        inp.close();
    }
}
