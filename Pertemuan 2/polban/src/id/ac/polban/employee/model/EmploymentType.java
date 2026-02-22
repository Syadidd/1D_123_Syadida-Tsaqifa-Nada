package id.ac.polban.employee.model;

public class EmploymentType {
    // Static field: konstanta tipe karyawan yang tersedia
    public static final String PERMANENT  = "Permanent";
    public static final String CONTRACT   = "Contract";
    public static final String INTERN     = "Intern";

    // Static field: batas gaji minimum per tipe (dalam Rupiah)
    public static final double MIN_SALARY_PERMANENT = 5_000_000;
    public static final double MIN_SALARY_CONTRACT  = 3_000_000;
    public static final double MIN_SALARY_INTERN    = 1_500_000;

    private String type;

    public EmploymentType(String type) {
        this.type = type;
    }

    // Static factory method: membuat objek berdasarkan tipe yang dikenal
    public static EmploymentType of(String type) {
        if (type.equals(PERMANENT) || type.equals(CONTRACT) || type.equals(INTERN)) {
            return new EmploymentType(type);
        }
        throw new IllegalArgumentException("Tipe karyawan tidak dikenal: " + type);
    }

    // Static method: mendapatkan gaji minimum berdasarkan tipe
    public static double getMinSalary(String type) {
        switch (type) {
            case PERMANENT: return MIN_SALARY_PERMANENT;
            case CONTRACT:  return MIN_SALARY_CONTRACT;
            case INTERN:    return MIN_SALARY_INTERN;
            default: throw new IllegalArgumentException("Tipe tidak dikenal: " + type);
        }
    }

    // Static method: cek apakah tipe karyawan valid
    public static boolean isValid(String type) {
        return type.equals(PERMANENT) || type.equals(CONTRACT) || type.equals(INTERN);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
