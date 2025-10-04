import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', marks=%.2f}", name, marks);
    }
}

public class StudentStreamExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 82.5),
                new Student("Bob", 68.0),
                new Student("Charlie", 91.0),
                new Student("David", 73.5),
                new Student("Eve", 78.0),
                new Student("Frank", 88.0));

        System.out.println("Students scoring above 75% sorted by marks:");

        students.stream()
                .filter(student -> student.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
