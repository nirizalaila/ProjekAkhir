import java.util.Scanner;

public class BookingTiketKereta {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        
        // input

        /*String nama;
        int jml_tiket, harga_tiket, jml_pembayaran, no_telp;*/
        int pilihan, harga_tiket = 0;
        String kelas = null;


        System.out.println("==== PEMESANAN TIKET KERETA API ====");
        System.out.println("======= Masukkan Nama anda : =======");
        String nama = sc.next();
        System.out.println("======= Pilih kelas kereta : =======\n1.Ekonomi\n2.Bisnis\n3.Eksekutif\n");
        System.out.println("Pilihan : ");
        pilihan = sc.nextInt();

        if (pilihan == 1){
            kelas = "Ekonomi";
            harga_tiket = 45000;
        
        } else if (pilihan == 2){
            kelas = "Bisnis";
            harga_tiket = 65000;

        } else if (pilihan == 3){
            kelas = "Eksekutif";
            harga_tiket = 80000;

        } else {
            System.out.println("Input yang anda masukkan salah");
        }

        System.out.println("==================================");
        System.out.println("Tiket terpilih : \nAtas nama : " + nama );
        System.out.println("== Kelas " + kelas + " Dengan harga Rp." + harga_tiket + " ==");


        

        /*System.out.println("Masukkan Nama :");
        nama = sc.next();
        System.out.println("Masukkan Nomor Telepon");
        no_telp = sc.nextInt();
        System.out.println("Masukkan jumlah tiket yang dibeli :");
        jml_tiket = sc.nextInt();
        System.out.println("Masukkan harga tiket yang dibeli :");
        harga_tiket = sc.nextInt();

        // output
        jml_pembayaran = jml_tiket*harga_tiket;
        System.out.println("Total Pembayaran atas nama " + nama + " adalah " + jml_pembayaran);*/

    }
}
