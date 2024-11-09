import java.util.*;

public class Employee {
    public String yearOfJoining;
    public String discipline;
    public String group;
    public String campus;
    public int idno;

    public Employee(String yearOfJoining, String discipline, String group, String campus) {
        this.yearOfJoining = yearOfJoining;
        this.discipline = discipline;
        this.group = group;
        this.campus = campus;
        this.idno = (int) (Math.random() * 900) + 100;
    }

    public void getEmail() {
        String email = this.yearOfJoining;

        switch (this.discipline.toLowerCase()) {
            case "chem":
                email = email.concat("A1");
                break;
            case "eee":
                email = email.concat("A3");
                break;
            case "mech":
                email = email.concat("A4");
                break;
            case "cs":
                email = email.concat("A7");
                break;
            default:
                System.out.println("Invalid discipline!");
                return;
        }

        if (this.group.equalsIgnoreCase("s")) {
            email = email.concat("S");
        } else if (this.group.equalsIgnoreCase("f")) {
            email = email.concat("F");
        } else {
            System.out.println("Invalid group!");
            return;
        }

        email = email.concat(String.valueOf(this.idno));

        String campusName = "";
        switch (this.campus.toLowerCase()) {
            case "p":
                campusName = "pilani";
                email = email.concat("P");
                break;
            case "h":
                campusName = "hyderabad";
                email = email.concat("H");
                break;
            case "g":
                campusName = "goa";
                email = email.concat("G");
                break;
            case "u":
                campusName = "dubai";
                email = email.concat("U");
                break;
            default:
                System.out.println("Invalid campus!");
                return;
        }
        System.out.println("Generated Email: " + email.toUpperCase() + " f" + this.yearOfJoining + idno + "@" + campusName + ".bits-pilani.ac.in");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year of joining: ");
        String yearOfJoining = scanner.nextLine();

        System.out.println("Enter discipline (CHEM, EEE, MECH, CS): ");
        String discipline = scanner.nextLine();

        System.out.println("(S) Staff or (F) Faculty: ");
        String group = scanner.nextLine();

        System.out.println("Enter campus (P) Pilani, (H) Hyderabad, (G) Goa, (U) Dubai: ");
        String campus = scanner.nextLine();

        Employee employee = new Employee(yearOfJoining, discipline, group, campus);
        employee.getEmail();
        scanner.close();
    }
}

