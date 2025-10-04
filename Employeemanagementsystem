import java.io.*;
import java.util.*;

// Employee class
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String designation;
    double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void display() {
        System.out.printf("ID: %d | Name: %s | Designation: %s | Salary: %.2f%n",
                id, name, designation, salary);
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.ser";

    // Save list of employees to file
    private static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    // Load list of employees from file
    @SuppressWarnings("unchecked")
    private static List<Employee> loadEmployees() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>(); // empty if no file
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = loadEmployees(); // Load existing employees

        while (true) {
            System.out.println("\n=== Employee Management Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a number (1-3).");
                sc.nextLine(); // clear buffer
                continue;
            }
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Designation: ");
                        String desig = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine(); // consume newline

                        Employee emp = new Employee(id, name, desig, salary);
                        employees.add(emp);
                        saveEmployees(employees);
                        System.out.println("✅ Employee added successfully!");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input type. Please try again.");
                        sc.nextLine(); // clear buffer
                    }
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("\n--- Employee Records ---");
                        for (Employee emp : employees) {
                            emp.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
