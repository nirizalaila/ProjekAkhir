import java.util.Scanner;

public class BookingTiketKereta {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int jml_tiket, harga_tiket, jml_pembayaran;
        System.out.println("Masukkan jumlah tiket yang dibeli");
        jml_tiket = sc.nextInt();
        System.out.println("Masukkan harga tiket yang dibeli");
        harga_tiket = sc.nextInt();
        jml_pembayaran = jml_tiket*harga_tiket;
        System.out.println("Total Pembayaran adalah " + jml_pembayaran);

    }
}
