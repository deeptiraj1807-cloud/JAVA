import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', age=%d, salary=%.2f}", name, age, salary);
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Sachin", 30, 70000));
        employees.add(new Employee("Sahil", 25, 50000));
        employees.add(new Employee("Sanya", 28, 60000));
        employees.add(new Employee("Aryan", 35, 90000));
        employees.add(new Employee("Shubham", 22, 40000));

        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        System.out.println("Sorted by name:");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("\nSorted by age:");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("\nSorted by salary (descending):");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("\nSorted by salary (ascending):");
        employees.forEach(System.out::println);
    }
}
