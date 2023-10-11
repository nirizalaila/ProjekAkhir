import java.util.Scanner;
public class BookingTiketKeretaDiskon {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        int jml_tiket, harga_tiket;
        double dis, jmlDis, jml_pembayaran, total;
        System.out.println("Masukkan jumlah tiket yang dibeli");
        jml_tiket = sc.nextInt();
        System.out.println("Masukkan harga tiket");
        harga_tiket = sc.nextInt();
        System.out.println("Masukkan besaran diskon");
        dis = sc.nextDouble();
        total = harga_tiket*jml_tiket;
        jmlDis = total*dis;
        jml_pembayaran = total-jmlDis;
        System.out.println("Diskon yang anda dapatkan adalah " + jmlDis);
        System.out.println("Jumlah yang dibayar adalah " + jml_pembayaran);
    }
}
