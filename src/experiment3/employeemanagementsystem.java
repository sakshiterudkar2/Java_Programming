package experiment3;
class employee {
    int id;
    String name;

    void getEmployee(int i, String n) {
        id = i;
        name = n;
    }

    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }

    // Method Overloading
    void calculateSalary(int basic) {
        System.out.println("Salary: " + basic);
    }

    void calculateSalary(int basic, int bonus) {
        System.out.println("Salary with Bonus: " + (basic + bonus));
    }

    // Method to be overridden
    void role() {
        System.out.println("Employee Role");
    }
}

// Child Class
class Manager extends employee {

    // Method Overriding
    void role() {
        System.out.println("Role: Manager");
    }
}


public class employeemanagementsystem {
	public static void main(String[] args) {

        Manager m = new Manager();

        m.getEmployee(101, "sakshi");
        m.display();

        m.role();

        // Method Overloading
        m.calculateSalary(30000);
        m.calculateSalary(30000, 5000);
    }
}

