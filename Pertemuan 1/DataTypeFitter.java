import java.util.Scanner;
import java.math.BigInteger;

public class DataTypeFitter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Membaca jumlah test case
        int T = sc.nextInt();
        sc.nextLine(); // Membersihkan newline

        // Mendefinisikan batas-batas untuk setiap tipe data
        BigInteger byteMin = BigInteger.valueOf(Byte.MIN_VALUE);
        BigInteger byteMax = BigInteger.valueOf(Byte.MAX_VALUE);
        BigInteger shortMin = BigInteger.valueOf(Short.MIN_VALUE);
        BigInteger shortMax = BigInteger.valueOf(Short.MAX_VALUE);
        BigInteger intMin = BigInteger.valueOf(Integer.MIN_VALUE);
        BigInteger intMax = BigInteger.valueOf(Integer.MAX_VALUE);
        BigInteger longMin = BigInteger.valueOf(Long.MIN_VALUE);
        BigInteger longMax = BigInteger.valueOf(Long.MAX_VALUE);

        // Memproses setiap test case
        for (int i = 0; i < T; i++) {
            String input = sc.nextLine();
            BigInteger n = new BigInteger(input);

            boolean canFit = false;

            // Mengecek apakah bisa disimpan di byte
            if (n.compareTo(byteMin) >= 0 && n.compareTo(byteMax) <= 0) {
                if (!canFit) {
                    System.out.println(n + " can be fitted in:");
                    canFit = true;
                }
                System.out.println("* byte");
            }

            // Mengecek apakah bisa disimpan di short
            if (n.compareTo(shortMin) >= 0 && n.compareTo(shortMax) <= 0) {
                if (!canFit) {
                    System.out.println(n + " can be fitted in:");
                    canFit = true;
                }
                System.out.println("* short");
            }

            // Mengecek apakah bisa disimpan di int
            if (n.compareTo(intMin) >= 0 && n.compareTo(intMax) <= 0) {
                if (!canFit) {
                    System.out.println(n + " can be fitted in:");
                    canFit = true;
                }
                System.out.println("* int");
            }

            // Mengecek apakah bisa disimpan di long
            if (n.compareTo(longMin) >= 0 && n.compareTo(longMax) <= 0) {
                if (!canFit) {
                    System.out.println(n + " can be fitted in:");
                    canFit = true;
                }
                System.out.println("* long");
            }

            // Jika tidak bisa disimpan di tipe data manapun
            if (!canFit) {
                System.out.println(n + " can't be fitted anywhere.");
            }
        }

        sc.close();
    }
}
