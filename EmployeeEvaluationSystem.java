import java.util.*;

class Employee {
    int empId;
    String name;
    double attendance;
    double projectScore;
    double teamwork;
    double communication;

    double totalScore;
    String rating;

    Employee(int empId, String name, double attendance, double projectScore,
             double teamwork, double communication) {
        this.empId = empId;
        this.name = name;
        this.attendance = attendance;
        this.projectScore = projectScore;
        this.teamwork = teamwork;
        this.communication = communication;
    }

      void calculatePerformance() {
        // Weighted average
        totalScore = (attendance * 0.2) +
                     (projectScore * 0.4) +
                     (teamwork * 0.2) +
                     (communication * 0.2);

       
        if (totalScore >= 85)
            rating = "Excellent";
        else if (totalScore >= 70)
            rating = "Good";
        else if (totalScore >= 50)
            rating = "Average";
        else
            rating = "Needs Improvement";
    }

       void display() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Attendance: " + attendance);
        System.out.println("Project Score: " + projectScore);
        System.out.println("Teamwork: " + teamwork);
        System.out.println("Communication: " + communication);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Rating: " + rating);
    }
}

public class EmployeeEvaluationSystem {

    static ArrayList<Employee> empList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Employee Performance System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Calculate Performance");
            System.out.println("3. Display All Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee(sc);
                    break;

                case 2:
                    calculateAll();
                    break;

                case 3:
                    displayAll();
                    break;

                case 4:
                    searchEmployee(sc);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

 
    static void addEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Attendance (0-100): ");
        double att = sc.nextDouble();

        System.out.print("Enter Project Score (0-100): ");
        double proj = sc.nextDouble();

        System.out.print("Enter Teamwork (0-100): ");
        double team = sc.nextDouble();

        System.out.print("Enter Communication (0-100): ");
        double comm = sc.nextDouble();

        Employee emp = new Employee(id, name, att, proj, team, comm);
        empList.add(emp);

        System.out.println("Employee added successfully!");
    }

       static void calculateAll() {
        if (empList.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        for (Employee emp : empList) {
            emp.calculatePerformance();
        }

        System.out.println("Performance calculated for all employees!");
    }

       static void displayAll() {
        if (empList.isEmpty()) {
            System.out.println("No employees to display!");
            return;
        }

        for (Employee emp : empList) {
            emp.display();
        }
    }

      static void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (Employee emp : empList) {
            if (emp.empId == id) {
                emp.display();
                return;
            }
        }

        System.out.println("Employee not found!");
    }
}