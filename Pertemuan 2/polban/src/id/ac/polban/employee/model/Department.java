package id.ac.polban.employee.model;

public class Department {
    // Static field: menyimpan jumlah departemen yang telah dibuat
    private static int departmentCount = 0;

    // Static field: konstanta nama departemen yang valid
    public static final String ENGINEERING  = "Engineering";
    public static final String FINANCE      = "Finance";
    public static final String HR           = "Human Resources";
    public static final String MARKETING    = "Marketing";

    private String name;

    public Department(String name) {
        this.name = name;
        departmentCount++; // setiap objek baru dibuat, counter bertambah
    }

    // Static method: mendapatkan jumlah departemen yang telah dibuat
    public static int getDepartmentCount() {
        return departmentCount;
    }

    // Static method: memvalidasi apakah nama departemen termasuk yang dikenal
    public static boolean isValidDepartment(String name) {
        return name.equals(ENGINEERING) ||
                name.equals(FINANCE)     ||
                name.equals(HR)          ||
                name.equals(MARKETING);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
