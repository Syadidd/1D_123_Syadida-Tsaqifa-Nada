public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public String[] getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String[] nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public int[] getStok() {
        return stok;
    }

    public void setStok(int[] stok) {
        for (int i = 0; i < stok.length; i++) {
            if (stok[i] < 0) {
                throw new IllegalArgumentException(
                        "Stok tidak boleh negatif pada indeks ke-" + i + ": " + stok[i]);
            }
        }
        this.stok = stok;
    }

    public double[] getHarga_makanan() {
        return harga_makanan;
    }

    public void setHarga_makanan(double[] harga_makanan) {
        this.harga_makanan = harga_makanan;
    }

    public static byte getId() {
        return id;
    }

    public static void setId(byte id) {
        Restaurant.id = id;
    }

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if (stok < 0) {
            throw new IllegalArgumentException(
                    "Stok tidak boleh negatif: " + stok);
        }
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }

    public void tampilMenuMakanan() {
        System.out.println("===== DAFTAR MENU =====");
        System.out.println(String.format("%-4s %-20s %-8s %s", "No", "Nama Makanan", "Stok", "Harga"));
        System.out.println("-------------------------------------------------------");
        boolean adaMenu = false;
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(String.format("%-4d %-20s %-8s Rp. %,.0f",
                        (i + 1),
                        nama_makanan[i],
                        "[" + stok[i] + "]",
                        harga_makanan[i]));
                adaMenu = true;
            }
        }
        if (!adaMenu) {
            System.out.println("Semua menu sedang habis.");
        }
        System.out.println("-------------------------------------------------------");
    }

    public double pesanMakanan(int nomorMenu, int jumlah) {
        int index = nomorMenu - 1;

        // Validasi nomor menu
        if (index < 0 || index > id) {
            System.out.println("Pesanan DITOLAK: Nomor menu tidak valid.");
            return -1;
        }

        // Validasi jumlah pesanan
        if (jumlah <= 0) {
            System.out.println("Pesanan DITOLAK: Jumlah pesanan harus lebih dari 0.");
            return -1;
        }

        // Cek stok habis
        if (isOutOfStock(index)) {
            System.out.println("Pesanan DITOLAK: Stok " + nama_makanan[index] + " sudah habis.");
            return -1;
        }

        // Cek stok mencukupi
        if (stok[index] < jumlah) {
            System.out.println("Pesanan DITOLAK: Stok " + nama_makanan[index] +
                    " tidak mencukupi. Stok tersedia: " + stok[index] + ", jumlah dipesan: " + jumlah);
            return -1;
        }

        // Proses pemesanan: kurangi stok
        stok[index] -= jumlah;
        double totalHarga = harga_makanan[index] * jumlah;

        // Tampilkan struk pesanan
        System.out.println("===== PESANAN BERHASIL =====");
        System.out.println("Menu     : " + nama_makanan[index]);
        System.out.println("Jumlah   : " + jumlah + " porsi");
        System.out.println("Harga    : Rp. " + harga_makanan[index] + " x " + jumlah);
        System.out.println("Total    : Rp. " + totalHarga);
        System.out.println("Sisa Stok: " + stok[index]);
        System.out.println("============================");

        return totalHarga;
    }

    private boolean isOutOfStock(int id) {
        return stok[id] == 0;
    }

    public static void nextId() {
        id++;
    }
}