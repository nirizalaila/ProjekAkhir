import java.util.Scanner;

public class BookingTiketKereta {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // input

        String nama;
        int jml_tiket, harga_tiket, jml_pembayaran, no_telp;

        System.out.println("== PEMESANAN TIKET KERETA API ==");

        System.out.println("Masukkan Nama :");
        nama = sc.next();
        System.out.println("Masukkan Nomor Telepon");
        no_telp = sc.nextInt();
        System.out.println("Masukkan jumlah tiket yang dibeli :");
        jml_tiket = sc.nextInt();
        System.out.println("Masukkan harga tiket yang dibeli :");
        harga_tiket = sc.nextInt();

        // output
        jml_pembayaran = jml_tiket*harga_tiket;
        System.out.println("Total Pembayaran atas nama " + nama + " adalah " + jml_pembayaran);

    }
}
