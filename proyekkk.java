import java.util.Scanner;

public class proyekkk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int pilihmenu;

        do {
            System.out.println("=============================================================");
            System.out.println("========== SELAMAT DATANG DI SISTEM BOOKING KERETA ==========");
            System.out.println("=============================================================");
            System.out.println("\nDaftar Menu = \n1.Pesan Tiket\n2.Tampilkan Jadwal\n3.Tampilkan Harga\n4.Exit");
            System.out.print("\nPilihan : ");
            pilihmenu = sc.nextInt();

            switch (pilihmenu) {
                case 1:
                    pesanTiket();
                    break;
                case 2:
                    tampilkanJadwal();
                    break;
                case 3:
                    tampilkanHargaTiket();
                    break;
                case 4:
                    System.out.println("=============================================================");
                    System.out.println("==============\t\tTERIMA KASIH\t\t=============");
                    System.out.println("=============================================================");
                    break;
                default:
                    System.out.println("=============== INPUT YANG ANDA MASUKKAN SALAH ==============\n\n");
            }
        } while (pilihmenu != 4);
    }

    public static void pesanTiket() {
        System.out.println("=============================================================");
        System.out.println("==============\t\tPESAN TIKET\t\t=============");
        System.out.println("=============================================================");
    
    }

    public static void tampilkanJadwal() {
        tampilkanJadwalKereta();
        tampilkanHargaTiket();
    }

    public static void tampilkanJadwalKereta() {

        Scanner sc = new Scanner(System.in);

        String[] kelas = { "Ekonomi", "Bisnis", "Eksekutif" };
        String[] kota = { "Jakarta", "Bandung", "Cirebon", "Purwokerto", "Semarang", "Yogyakarta", "Solo", "Kediri",
                "Malang", "Surabaya" };
        double[][] jarak = {
                { 0, 150, 210, 350, 450, 560, 550, 710, 850, 800 },
                { 150, 0, 160, 310, 420, 530, 520, 680, 820, 770 },
                { 210, 160, 0, 290, 400, 510, 500, 660, 800, 750 },
                { 350, 310, 290, 0, 110, 220, 210, 370, 510, 460 },
                { 450, 420, 400, 110, 0, 110, 100, 260, 400, 350 },
                { 560, 530, 510, 220, 110, 0, 90, 250, 390, 340 },
                { 550, 520, 500, 210, 100, 90, 0, 160, 300, 250 },
                { 710, 680, 660, 370, 260, 250, 160, 0, 140, 90 },
                { 850, 820, 800, 510, 400, 390, 300, 140, 0, 50 },
                { 800, 770, 750, 460, 350, 340, 250, 90, 50, 0 }
        };

        // Tampilkan menu pilihan kota
        System.out.println("================================");
        System.out.println("===  Tampilkan Jadwal Kereta ===");
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

        // Pilih kota dan kelas
        int pilihKota;
        int pilihKelas;
        int pilihTampilkanJadwal = 0;
        do {
            System.out.print("\nPilih Kota   : ");
            pilihKota = sc.nextInt();
            System.out.println("\n================================");
            System.out.println("Daftar Kelas : ");
            for (int i = 0; i < kelas.length; i++) {
                System.out.println((i + 1) + ". " + kelas[i]);
            }
            System.out.println("================================");
            System.out.print("Pilih Kelas  : ");
            pilihKelas = sc.nextInt();

            // Validasi input kota dan kelas
            if (pilihKota < 1 || pilihKota > kota.length || pilihKelas < 1 || pilihKelas > kelas.length) {
                System.out.println("Pilihan Kota atau Kelas tidak valid! Silahkan coba lagi!");
            }
        

        // Tentukan kecepatan berdasarkan kelas
        double kecepatan = (pilihKelas == 1) ? 80 : ((pilihKelas == 2) ? 90 : 100);

        // Tampilkan waktu perjalanan untuk kota terpilih dan kelas terpilih
        System.out.println("=====================================");
        System.out.println("Pilihan Kota   : " + kota[pilihKota - 1]);
        System.out.println("Pilihan Kelas  : " + kelas[pilihKelas - 1]);
        System.out.println("=====================================");
        for (int i = 0; i < kota.length; i++) {
            if (i != pilihKota - 1) {
                double jarakTempuh = jarak[pilihKota - 1][i];
                double waktuTempuh = jarakTempuh / kecepatan;
                int jamMulai = 8;
                int[] waktuSelesai = hitungWaktuSelesai(jamMulai, waktuTempuh);
                System.out.printf("%2d. Ke %s: %02d:%02d - %02d:%02d\n", (i + 1), kota[i], jamMulai, 0,
                        waktuSelesai[0], waktuSelesai[1]);
            }
        }
        System.out.println("=====================================");

        // Pilihan untuk kembali ke menu utama atau melihat daftar harga lain
        
            System.out.println("\n1. Kembali ke Menu Utama\n2. Kembali Melihat daftar Harga Lain");
            System.out.print("\nPilihan : ");
            pilihTampilkanJadwal = sc.nextInt();

            // Implementasi pilihan
            switch (pilihTampilkanJadwal) {
                case 1:
                    System.out.println("Kembali ke Menu Utama");
                    break;
                case 2:
                    System.out.println("Kembali Melihat jadwal lain");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihKota < 1 || pilihKota > kota.length || pilihKelas < 1 || pilihKelas > kelas.length || pilihTampilkanJadwal == 2);
    }

    // Method untuk menghitung waktu selesai perjalanan
    private static int[] hitungWaktuSelesai(int jamMulai, double waktu) {
        int totalMenit = (int) (waktu * 60);
        int menitSelesai = (jamMulai * 60 + totalMenit) % (24 * 60);
        return new int[] { menitSelesai / 60, menitSelesai % 60 };
    }



    public static void tampilkanHargaTiket() {
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
                        { 350000, 250000, 150000, 0, 200000, 250000, 300000, 350000, 400000, 450000 },
                        { 400000, 300000, 200000, 150000, 0, 200000, 250000, 300000, 350000, 400000 },
                        { 450000, 350000, 300000, 250000, 200000, 0, 200000, 250000, 300000, 350000 },
                        { 500000, 400000, 350000, 300000, 250000, 200000, 0, 200000, 250000, 300000 },
                        { 550000, 450000, 400000, 350000, 300000, 250000, 200000, 0, 200000, 250000 },
                        { 600000, 500000, 450000, 400000, 350000, 300000, 250000, 200000, 0, 200000 },
                        { 650000, 550000, 500000, 450000, 400000, 350000, 300000, 250000, 200000, 0 } }
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
                System.out.println(
                        "Harga Tiket " + kelas[pilihKelas - 1] + " dari " + kota[pilihKota - 1] + " ke kota lain:");

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
        } while (pilihKota < 1 || pilihKota > kota.length || pilihKelas < 1 || pilihKelas > kelas.length
                || pilihDaftarHarga == 2);
    }

}
