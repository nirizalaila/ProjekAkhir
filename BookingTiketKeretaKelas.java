import java.util.Scanner;
public class BookingTiketKeretaKelas {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int jml_tiket, jml_pembayaran, hargaReguler = 12000, hargaBisnis = 30000, hargaEksekutif = 45000;
        String Kelas = "Reguler";
        System.out.print("Masukkan Kelas Kereta: ");
        Kelas = sc.next();
        switch (Kelas) {
            case "Reguler":
            System.out.println("Anda berhasil memesan tiket kelas Reguler");
            System.out.print("Masukkan jumlah tiket: ");
            jml_tiket = sc.nextInt();
            jml_pembayaran = jml_tiket*hargaReguler;
            System.out.println(jml_tiket + " * " + hargaReguler + " = " + jml_pembayaran);
            System.out.println("Total Pembayaran: " + jml_pembayaran);
            break;
            case "Bisnis":
            System.out.println("Anda berhasil memesan tiket kelas Bisnis");
            System.out.print("Masukkan jumlah tiket: ");
            jml_tiket = sc.nextInt();
            jml_pembayaran = jml_tiket*hargaBisnis;
            System.out.println(jml_tiket + " * " + hargaBisnis + " = " + jml_pembayaran);
            System.out.println("Total Pembayaran: " + jml_pembayaran);
            break;
            case "Eksekutif":
            System.out.println("Anda berhasil memesan tiket kelas Ekekutif");
            System.out.print("Masukkan jumlah tiket: ");
            jml_tiket = sc.nextInt();
            jml_pembayaran = jml_tiket*hargaEksekutif;
            System.out.println("Total Pembayaran: " + jml_pembayaran);
            break;

            default:
            System.out.println("Maaf kelas yang anda masukkan tidak tersedia");
        }
    }
}
