package id.ac.polban.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.ac.polban.employee.model.*;

public class EmployeeService {
    // Static field: persentase kenaikan gaji maksimum yang diizinkan
    private static final double MAX_RAISE_PERCENT = 50.0;

    // Static field: bonus flat untuk karyawan Permanent (dalam Rupiah)
    private static final double PERMANENT_BONUS = 2_000_000;

    private Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        // Validasi gaji minimum menggunakan static method dari EmploymentType
        double minSalary = EmploymentType.getMinSalary(emp.getType().getType());
        if (emp.getSalary() < minSalary) {
            System.out.printf("Peringatan: Gaji %s di bawah minimum (%s) untuk tipe %s%n",
                    Employee.formatSalary(emp.getSalary()),
                    Employee.formatSalary(minSalary),
                    emp.getType().getType());
        }
        employees.put(emp.getId(), emp);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        // Static method digunakan untuk validasi batas kenaikan
        if (!isValidRaisePercent(percent)) {
            System.out.printf("Kenaikan %.1f%% melebihi batas maksimum %.1f%%%n",
                    percent, MAX_RAISE_PERCENT);
            return;
        }
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() * (1 + percent / 100));
        }
    }

    // Static method: validasi persentase kenaikan gaji
    public static boolean isValidRaisePercent(double percent) {
        return percent > 0 && percent <= MAX_RAISE_PERCENT;
    }

    // Static method: hitung total pengeluaran gaji dari daftar karyawan
    public static double calculateTotalPayroll(List<Employee> empList) {
        double total = 0;
        for (Employee emp : empList) {
            total += emp.getSalary();
        }
        return total;
    }

    // Static method: hitung gaji setelah bonus berdasarkan tipe karyawan
    public static double calculateSalaryWithBonus(Employee emp) {
        if (emp.getType().getType().equals(EmploymentType.PERMANENT)) {
            return emp.getSalary() + PERMANENT_BONUS;
        }
        return emp.getSalary();
    }

    // Static method: filter karyawan berdasarkan departemen
    public static List<Employee> filterByDepartment(List<Employee> empList, String deptName) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : empList) {
            if (emp.getDepartment().getName().equals(deptName)) {
                result.add(emp);
            }
        }
        return result;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }
}