import java.util.Scanner;
class Employee {
    public String emID;
    public String emName;
    public int emDept;
    public float basic,allowance,totalSalary;
    public float HRA;
    
    Employee(String emID, String emName, int emDept, float basic, float allowance, float totalSalary, float HRA) {
        this.emID = emID;
        this.emName = emName;
        this.emDept = emDept;
        this.basic = basic;
        this.allowance = allowance;
        this.totalSalary = totalSalary;
        this.HRA = HRA;
    }
    
    public void Display() {
        System.out.println("Employee ID: " + emID);
        System.out.println("Employee Name: " + emName);
        System.out.println("Employee Dept: " + emDept);
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + HRA);
        System.out.println("Allowance: " + allowance);
        System.out.println("Total Salary: " + totalSalary);
    }

}
public class EmployeeTester {
    public static void main(String[] args) {
        
        Employee[] employees = new Employee[3];
        Scanner scanner = new Scanner(System.in);
        
        for (int i=0; i<3; i++) {
            
            System.out.println("Enter details of employee" + (i+1) + ":");

            System.out.print("Enter employee id: ");
            String emID = scanner.nextLine();
            scanner.nextLine();

            System.out.print("Enter employee name: ");
            String emName = scanner.nextLine();

            System.out.print("Enter employee dept: ");
            int emDept = scanner.nextInt();
            float allowance = 0;
            switch(emDept){
                case 1:
                allowance = 1500;
                break;
                case 2:
                allowance = 2500;
                break;
                case 3:
                allowance = 3500;
                break;
                default:
                System.out.println("Invalid emDept input! ");
            }
            
            System.out.print("Enter your basic salary: ");
            float basic = scanner.nextInt();
            
            float HRA = ((basic/100)*40);
            
            float totalSalary = basic + HRA + allowance;
            
            employees[i] = new Employee(emID, emName, emDept, basic, allowance, totalSalary, HRA); 
        }
            
            System.out.println("\nDisplaying employees:");
            
            for (int i = 0; i < 3; i++) {
                System.out.println("Employee " + (i + 1) + ":");
                employees[i].Display();
                System.out.println();
            }
                
            scanner.close(); 
            
        }
        
    }
