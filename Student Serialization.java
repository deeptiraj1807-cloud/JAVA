import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int studentID;
    String name;
    char grade;

    public Student(int studentID, String name, char grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void display() {
        System.out.println("ID: " + studentID + ", Name: " + name + ", Grade: " + grade);
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
        String fileName = "student.ser";

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Student s1 = new Student(101, "Rahul", 'A');
            oos.writeObject(s1);
            System.out.println("Student object serialized to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student s2 = (Student) ois.readObject();
            System.out.println("Deserialized Student object:");
            s2.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
