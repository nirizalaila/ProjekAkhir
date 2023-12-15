import java.util.Scanner;

public class tampilkanharga {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String kelas[] = { "Ekonomi", "Bisnis", "Eksekutif" };

        int hargaTiket[][][] = {
            // Daftar Harga Tiket Ekonomi
            { { 0, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000 },
              { 100000, 0, 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000 },
              { 150000, 50000, 0, 50000, 100000, 150000, 200000, 250000, 300000, 350000 },
              { 200000, 100000, 50000, 0, 50000, 100000, 150000, 200000, 250000, 300000 },
              { 250000, 150000, 100000, 50000, 0, 50000, 100000, 150000, 200000, 250000 },
              { 300000, 200000, 150000, 100000, 50000, 0, 50000, 100000, 150000, 200000 },
              { 350000, 250000, 200000, 150000, 100000, 50000, 0, 50000, 100000, 150000 },
              { 400000, 300000, 250000, 200000, 150000, 100000, 50000, 0, 50000, 100000 },
              { 450000, 350000, 300000, 250000, 200000, 150000, 100000, 50000, 0, 50000 },
              { 500000, 400000, 350000, 300000, 250000, 200000, 150000, 100000, 50000, 0 }
            },
            // Daftar Harga Tiket Bisnis
            { { 0, 160000, 210000, 260000, 310000, 360000, 410000, 460000, 510000, 560000 },
              { 160000, 0, 110000, 160000, 210000, 260000, 310000, 360000, 410000, 460000 },
              { 210000, 110000, 0, 110000, 160000, 210000, 260000, 310000, 360000, 410000 },
              { 260000, 160000, 110000, 0, 110000, 160000, 210000, 260000, 310000, 360000 },
              { 310000, 210000, 160000, 110000, 0, 110000, 160000, 210000, 260000, 310000 },
              { 360000, 260000, 210000, 160000, 110000, 0, 110000, 160000, 210000, 260000 },
              { 410000, 310000, 260000, 210000, 160000, 110000, 0, 110000, 160000, 210000 },
              { 460000, 360000, 310000, 260000, 210000, 160000, 110000, 0, 110000, 160000 },
              { 510000, 410000, 360000, 310000, 260000, 210000, 160000, 110000, 0, 110000 },
              { 560000, 460000, 410000, 360000, 310000, 260000, 210000, 160000, 110000, 0 }
            },
            // Daftar Harga Tiket Eksekutif
            { { 0, 250000, 300000, 350000, 400000, 450000, 500000, 550000, 600000, 650000 },
              { 250000, 0, 200000, 250000, 300000, 350000, 400000, 450000, 500000, 550000 },
              { 300000, 200000, 0, 150000, 200000, 250000, 300000, 350000, 400000, 450000 },
              { 350000, 250000, 150000, 0, 200000, 250000, 300000, 350000, 400000, 450000},
              { 400000, 300000, 200000, 150000, 0, 200000, 250000, 300000, 350000, 400000 },
              { 450000, 350000, 250000, 200000, 150000, 0, 200000, 250000, 300000, 350000 },
              { 500000, 400000, 300000, 250000, 200000, 150000, 0, 200000, 250000, 300000 },
              { 550000, 450000, 350000, 300000, 250000, 200000, 150000, 0, 200000, 250000 },
              { 600000, 500000, 400000, 350000, 300000, 250000, 200000, 150000, 0, 200000 },
              { 650000, 550000, 450000, 400000, 350000, 300000, 250000, 200000, 150000, 0 }
            }
        };

        String kota[] = { "Jakarta", "Bandung", "Cirebon", "Purwokerto", "Semarang", "Yogyakarta", "Solo", "Kediri",
                "Malang", "Surabaya" };

        System.out.println("================================");
        System.out.println("==== Tampilkan Harga Tiket  ====");
        System.out.println("================================");

        for (int i = 0; i < kota.length; i++) {
            System.out.printf("%2d. %-10s", (i + 1), kota[i]);
            if ((i + 1) % 2 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
        System.out.println("================================");
        int pilihKota, pilihKelas, pilihDaftarHarga = 0;
        do {
        System.out.print("\nPilih Kota : ");
        pilihKota = sc.nextInt();

        System.out.println("\n================================");
        System.out.println("Daftar Kelas : ");
        for (int i = 0; i < kelas.length; i++) {
            System.out.println((i + 1) + ". " + kelas[i]);
        }
        System.out.println("================================");

        System.out.print("\nPilih Kelas   : ");
        pilihKelas = sc.nextInt();

        if (pilihKota >= 1 && pilihKota <= kota.length && pilihKelas >= 1 && pilihKelas <= kelas.length) {
            System.out.println("=====================================");
            System.out.println("Pilihan Kota   : " + kota[pilihKota - 1]);
            System.out.println("Pilihan Kelas  : " + kelas[pilihKelas - 1]);

            System.out.println("=====================================");
            System.out.println("Harga Tiket " + kelas[pilihKelas - 1] + " dari " + kota[pilihKota - 1] + " ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals(kota[pilihKota - 1])) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiket[pilihKelas - 1][pilihKota - 1][i]);
                }
            }
            System.out.println("=====================================");
            System.out.println("\n1. Kembali ke Menu Utama\n2. Kembali Melihat daftar Harga Lain");
            System.out.print("\nPilihan : ");
            pilihDaftarHarga = sc.nextInt();
        } else {
            System.out.println("Pilihan Kota atau Kelas tidak valid! Silahkan coba lagi!");
        }
        } while (pilihKota < 1 || pilihKota > kota.length || pilihKelas < 1 || pilihKelas > kelas.length || pilihDaftarHarga == 2);
    }
}
