package experiment2;
import java.util.*;

class Student {
    int rollNo;
    String name;
    double marks;

    // Constructor
    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Method to display student details
    void display() {
        System.out.println("Roll No: " + rollNo + " Name: " + name + " Marks: " + marks);
    }
}

// Comparator class to sort students by marks
class SortByMarks implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return Double.compare(a.marks, b.marks);
    }
}



public class studentrecord {
	public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        // Adding student records
        students.add(new Student(101, "sakshi", 85));
        students.add(new Student(102, "rutuja", 92));
        students.add(new Student(103, "shreya", 78));
        students.add(new Student(104, "snehal", 88));

        System.out.println("Student Records:");
        for (Student s : students) {
            s.display();
        }

        // Sorting students by marks
        Collections.sort(students, new SortByMarks());

        System.out.println("\nStudents Sorted by Marks:");
        for (Student s : students) {
            s.display();
        }
    }


}
