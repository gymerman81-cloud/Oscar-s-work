class Employee {
    String employeeID;
    String name;
    String department;
    double basicSalary;

    Employee(String employeeID, String name, String department, double basicSalary) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void displayInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);

        System.out.println("Category: " + getCategory());

        System.out.printf("Monthly Salary: $%.2f%n", calculateSalary());
        System.out.println();
    }

    String getCategory() {
        return "Employee";
    }
}

class FullTimeEmployee extends Employee {
    double allowance;

    FullTimeEmployee(String employeeID, String name, String department,
                     double basicSalary, double allowance) {
        super(employeeID, name, department, basicSalary);
        this.allowance = allowance;
    }

    @Override
    double calculateSalary() {
        return basicSalary + allowance;
    }

    @Override
    String getCategory() {
        return "Full-Time Employee";
    }
}

class PartTimeEmployee extends Employee {
    double hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String employeeID, String name, String department,
                     double hoursWorked, double hourlyRate) {
        super(employeeID, name, department, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    String getCategory() {
        return "Part-Time Employee";
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String employeeID, String name, String department,
            double basicSalary, double bonus) {
        super(employeeID, name, department, basicSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    String getCategory() {
        return "Manager";
    }
}

public class EmployeeSalarySystem {
    public static void main(String[] args) {

        Employee[] employees = {
                new FullTimeEmployee("EMP001", "Ahmed Ali", "IT", 500, 150),
                new PartTimeEmployee("EMP002", "Fatima Hassan", "Finance", 30, 8),
                new Manager("EMP003", "Mohamed Omar", "Management", 1000, 200)
        };

        System.out.println("EMPLOYEE SALARY REPORT");
        System.out.println();

        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }
}