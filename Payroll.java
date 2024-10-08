import java.util.*;

abstract class Employee {    
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calSalary();

    @Override
    public String toString() {
        return "Employee[name=" + name + ", Id:" + id + ", Salary:" + calSalary() + "]";
    }
}

class FulltimeEmp extends Employee {
    private double monthlysalary;

    public FulltimeEmp(String name, int id, double monthlysalary) {
        super(name, id);
        this.monthlysalary = monthlysalary;
    }

    @Override
    public double calSalary() {
        return monthlysalary;
    }
}

class PartTimeEmp extends Employee {
    private int hourwork;
    private double workrate;

    public PartTimeEmp(String name, int id, int hourwork, double workrate) {
        super(name, id);
        this.hourwork = hourwork;
        this.workrate = workrate;
    }

    @Override
    public double calSalary() {
        return hourwork * workrate;
    }
}

class Payroll {
    private ArrayList<Employee> employeelist;

    public Payroll() {
        employeelist = new ArrayList<>();
    }

    public void addEmp(Employee employee) {
        employeelist.add(employee);
    }

    public void removeEmp(int id) {
        Employee emptoremove = null;
        for (Employee employee : employeelist) {
            if (employee.getId() == id) {
                emptoremove = employee;
                break;
            }
        }
        if (emptoremove != null) {
            employeelist.remove(emptoremove);
        }
    }

    public void displayEmp() {
        for (Employee employee : employeelist) {
            System.out.println(employee);
        }
    }
}

public class oops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Payroll payrollsys = new Payroll();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Payroll System Menu ---");
            System.out.println("1. Add Full-time Employee");
            System.out.println("2. Add Part-time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String fullName = scanner.next();
                    System.out.print("Enter ID: ");
                    int fullId = scanner.nextInt();
                    System.out.print("Enter monthly salary: ");
                    double monthlySalary = scanner.nextDouble();
                    FulltimeEmp fullEmp = new FulltimeEmp(fullName, fullId, monthlySalary);
                    payrollsys.addEmp(fullEmp);
                    System.out.println("Full-time Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String partName = scanner.next();
                    System.out.print("Enter ID: ");
                    int partId = scanner.nextInt();
                    System.out.print("Enter hours worked: ");
                    int hoursWorked = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double hourlyRate = scanner.nextDouble();
                    PartTimeEmp partEmp = new PartTimeEmp(partName, partId, hoursWorked, hourlyRate);
                    payrollsys.addEmp(partEmp);
                    System.out.println("Part-time Employee added successfully.");
                    break;

                case 3:
                    System.out.print("Enter the ID of the employee to remove: ");
                    int removeId = scanner.nextInt();
                    payrollsys.removeEmp(removeId);
                    System.out.println("Employee removed successfully.");
                    break;

                case 4:
                    System.out.println("Displaying all employees:");
                    payrollsys.displayEmp();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
