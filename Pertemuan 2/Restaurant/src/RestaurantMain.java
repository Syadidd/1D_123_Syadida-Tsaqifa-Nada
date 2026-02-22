public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        // Tambah menu
        menu.tambahMenuMakanan("Pizza", 250000, 20);         Restaurant.nextId();
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);      Restaurant.nextId();
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30); Restaurant.nextId();
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        // Tampilkan menu awal
        menu.tampilMenuMakanan();

        // Kasus 1: Pesanan berhasil
        menu.pesanMakanan(1, 2);

        // Kasus 2: Pesanan berhasil
        menu.pesanMakanan(3, 5);

        // Kasus 3: Stok tidak mencukupi
        menu.pesanMakanan(2, 99);

        // Kasus 4: Nomor menu tidak valid
        menu.pesanMakanan(10, 1);

        // Kasus 5: Jumlah pesanan tidak valid
        menu.pesanMakanan(4, 0);

        // Tampilkan menu setelah pemesanan (stok sudah berkurang)
        menu.tampilMenuMakanan();
    }
}
