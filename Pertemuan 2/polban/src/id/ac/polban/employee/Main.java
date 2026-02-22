package id.ac.polban.employee;

import java.util.List;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        // ── 1. Static field: konstanta nama departemen ──────────────────────
        System.out.println("=== Departemen yang tersedia ===");
        System.out.println("- " + Department.ENGINEERING);
        System.out.println("- " + Department.FINANCE);
        System.out.println("- " + Department.HR);
        System.out.println("- " + Department.MARKETING);

        // ── 2. Static method: validasi nama departemen ──────────────────────
        System.out.println("\n=== Validasi Departemen ===");
        System.out.println("'Engineering' valid? " + Department.isValidDepartment(Department.ENGINEERING));
        System.out.println("'Sales' valid?       " + Department.isValidDepartment("Sales"));

        // Membuat objek Department
        Department eng = new Department(Department.ENGINEERING);
        Department fin = new Department(Department.FINANCE);
        Department hr  = new Department(Department.HR);

        // Static field: departmentCount bertambah otomatis
        System.out.println("\nTotal departemen dibuat: " + Department.getDepartmentCount());

        // ── 3. Static factory method: EmploymentType.of() ───────────────────
        System.out.println("\n=== Tipe Karyawan ===");
        EmploymentType permanent = EmploymentType.of(EmploymentType.PERMANENT);
        EmploymentType contract  = EmploymentType.of(EmploymentType.CONTRACT);
        EmploymentType intern    = EmploymentType.of(EmploymentType.INTERN);

        // Static method: gaji minimum per tipe
        System.out.printf("Gaji minimum Permanent : %s%n",
                Employee.formatSalary(EmploymentType.getMinSalary(EmploymentType.PERMANENT)));
        System.out.printf("Gaji minimum Contract  : %s%n",
                Employee.formatSalary(EmploymentType.getMinSalary(EmploymentType.CONTRACT)));
        System.out.printf("Gaji minimum Intern    : %s%n",
                Employee.formatSalary(EmploymentType.getMinSalary(EmploymentType.INTERN)));

        // ── 4. Static field: auto-increment ID pada Employee ────────────────
        System.out.println("\n=== Data Karyawan ===");
        Employee e1 = new Employee("Budi Santoso",   eng, permanent, 8_000_000);
        Employee e2 = new Employee("Siti Rahayu",    fin, contract,  4_500_000);
        Employee e3 = new Employee("Andi Pratama",   eng, intern,    1_500_000);
        Employee e4 = new Employee("Dewi Lestari",   hr,  permanent, 7_500_000);
        Employee e5 = new Employee("Rendi Kurniawan",eng, contract,  5_000_000);

        // Static field: totalEmployees
        System.out.println("Total karyawan dibuat: " + Employee.getTotalEmployees());

        // ── 5. EmployeeService ───────────────────────────────────────────────
        EmployeeService service = new EmployeeService();
        service.addEmployee(e1);
        service.addEmployee(e2);
        service.addEmployee(e3);
        service.addEmployee(e4);
        service.addEmployee(e5);

        System.out.println();
        for (Employee e : service.getAllEmployees()) {
            System.out.println(e); // memanggil toString()
        }

        // ── 6. Static method: raiseSalary dengan validasi ───────────────────
        System.out.println("\n=== Kenaikan Gaji ===");
        System.out.println("Kenaikan 10% untuk Budi (valid):");
        service.raiseSalary(e1.getId(), 10);
        System.out.println(e1);

        System.out.println("\nPercobaan kenaikan 60% (melebihi batas):");
        service.raiseSalary(e1.getId(), 60);

        // ── 7. Static method: calculateTotalPayroll ──────────────────────────
        List<Employee> all = service.getAllEmployees();
        double totalPayroll = EmployeeService.calculateTotalPayroll(all);
        System.out.printf("%nTotal pengeluaran gaji: %s%n", Employee.formatSalary(totalPayroll));

        // ── 8. Static method: calculateSalaryWithBonus ──────────────────────
        System.out.println("\n=== Gaji + Bonus Karyawan Permanent ===");
        for (Employee emp : all) {
            if (emp.getType().getType().equals(EmploymentType.PERMANENT)) {
                System.out.printf("%s -> gaji + bonus: %s%n",
                        emp.getName(),
                        Employee.formatSalary(EmployeeService.calculateSalaryWithBonus(emp)));
            }
        }

        // ── 9. Static method: filterByDepartment ────────────────────────────
        System.out.println("\n=== Karyawan di Departemen Engineering ===");
        List<Employee> engTeam = EmployeeService.filterByDepartment(all, Department.ENGINEERING);
        for (Employee emp : engTeam) {
            System.out.println(emp);
        }
        System.out.printf("Total payroll Engineering: %s%n",
                Employee.formatSalary(EmployeeService.calculateTotalPayroll(engTeam)));
    }
}