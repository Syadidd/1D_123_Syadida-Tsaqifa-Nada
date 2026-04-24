class Account { // Membuat class
    int balance = 150;
}

public class TransferFulus { // Kelas yang bisa diakses di package/folder yang sama
    public static void main(String[] args) throws InterruptedException { // Entry point
        Account acc1 = new Account(); // Membuat objek
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> { // Membuat objek thread baru
            synchronized (acc1) { // Mengunci acc1 agar tidak bisa diubah thread lain
                System.out.println("Thread 1: Mengunci acc1, menunggu 100ms...");
                try { Thread.sleep(100); } catch (Exception e) {} // Tidur sebentar. Exception utk penanganan jika ada yg interrupt().

                synchronized (acc2) { // Setelah bangun, mencoba mengunci acc2
                    System.out.println("Thread 1: Mengunci acc2, melakukan transfer!");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1.
                System.out.println("Thread 2: Mengunci acc1, menunggu 100ms...");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Mengunci acc2
                    System.out.println("Thread 2: Mengunci acc2, melakukan transfer!");
                    acc1.balance += acc2.balance;
                }
            }
        });

        // Memulai thread baru
        t1.start();
        t2.start();

        // Menunggu thread lain selesai sebelum melanjutkan
        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
