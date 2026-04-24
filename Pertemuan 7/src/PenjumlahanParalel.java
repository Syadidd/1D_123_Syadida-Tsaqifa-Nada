import java.util.Scanner;

public class PenjumlahanParalel {

    // Variabel bersama untuk menyimpan total akhir dari semua thread
    // volatile memastikan perubahan dari satu thread langsung terlihat oleh thread lain
    private static long totalAkhir = 0;

    // Objek kunci untuk sinkronisasi saat thread menambahkan hasil parsialnya
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = sc.nextInt();

        System.out.print("Masukkan angka akhir: ");
        long angkaAkhir = sc.nextLong();

        sc.close();

        // Menghitung ukuran bagian untuk setiap thread (Divide and Conquer)
        long ukuranBagian = angkaAkhir / jumlahThread;

        // Array untuk menyimpan semua thread
        Thread[] threads = new Thread[jumlahThread];

        System.out.println("\n=== Memulai Penjumlahan Paralel ===");

        // Membuat dan menjalankan setiap thread dengan rentang angka masing-masing
        for (int i = 0; i < jumlahThread; i++) {
            // Menghitung batas awal dan akhir untuk thread ke-i
            final long awal  = i * ukuranBagian + 1;
            final long akhir = (i == jumlahThread - 1) ? angkaAkhir : (i + 1) * ukuranBagian;
            final int  nomorThread = i + 1;

            threads[i] = new Thread(() -> {
                // Setiap thread menjumlahkan bagiannya sendiri secara lokal
                long hasilParsial = 0;
                System.out.println("Thread-" + nomorThread + ": menjumlahkan " + awal + " s.d. " + akhir);

                for (long j = awal; j <= akhir; j++) {
                    hasilParsial += j;
                }

                System.out.println("Thread-" + nomorThread + ": hasil parsial = " + hasilParsial);

                // Sinkronisasi saat menambahkan ke totalAkhir agar tidak race condition
                // Hanya satu thread yang bisa mengakses blok ini pada satu waktu
                synchronized (lock) {
                    totalAkhir += hasilParsial;
                }
            });

            threads[i].start();
        }

        // Main thread menunggu SEMUA thread selesai sebelum mencetak hasil
        for (Thread t : threads) {
            t.join();
        }

        // Verifikasi dengan rumus matematika: n * (n + 1) / 2
        long hasilBenar = angkaAkhir * (angkaAkhir + 1) / 2;

        System.out.println("\n=== HASIL AKHIR ===");
        System.out.println("Total dari semua thread : " + totalAkhir);
        System.out.println("Verifikasi (rumus n*(n+1)/2): " + hasilBenar);
        System.out.println("Status: " + (totalAkhir == hasilBenar ? "BENAR" : "SALAH"));
    }
}