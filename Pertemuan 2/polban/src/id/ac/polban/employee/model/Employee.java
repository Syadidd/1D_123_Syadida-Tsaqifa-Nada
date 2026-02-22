package id.ac.polban.employee.model;

public class Employee {
    // Static field: counter untuk generate ID otomatis
    private static int idCounter = 0;

    // Static field: total seluruh karyawan yang pernah dibuat
    private static int totalEmployees = 0;

    private int id;
    private String name;
    private Department department;
    private EmploymentType type;
    private double salary;

    public Employee(String name, Department department, EmploymentType type, double salary) {
        this.id         = generateId();          // ID otomatis dari static method
        this.name       = name;
        this.department = department;
        this.type       = type;
        this.salary     = salary;
        totalEmployees++;
    }

    // Konstruktor dengan ID manual (tetap dipertahankan untuk kompatibilitas)
    public Employee(int id, String name, Department department, EmploymentType type, double salary) {
        this.id         = id;
        this.name       = name;
        this.department = department;
        this.type       = type;
        this.salary     = salary;
        totalEmployees++;
        if (id > idCounter) idCounter = id; // sinkronkan counter
    }

    // Static method: generate ID unik secara otomatis
    private static int generateId() {
        return ++idCounter;
    }

    // Static method: mendapatkan total karyawan yang pernah dibuat
    public static int getTotalEmployees() {
        return totalEmployees;
    }

    // Static method: reset counter (berguna untuk keperluan testing)
    public static void resetCounter() {
        idCounter      = 0;
        totalEmployees = 0;
    }

    // Static method: format tampilan gaji
    public static String formatSalary(double salary) {
        return String.format("Rp %,.0f", salary);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public EmploymentType getType() { return type; }
    public void setType(EmploymentType type) { this.type = type; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return String.format("[%d] %s | %s | %s | %s",
                id, name, department, type, Employee.formatSalary(salary));
    }
}
