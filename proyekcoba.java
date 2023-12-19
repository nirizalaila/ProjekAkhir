import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class proyekcoba {
    static Scanner sc = new Scanner(System.in);
    static int totalHarga = 0;
    static int totalHargaMakanan = 0;
    static String[] menuMakanan = { "Bakso", "Nasi Goreng", "Mie Ayam", "Nasi Fried Chicken", "Roti Bakar", "Es Teh",
            "Air Mineral" };
    static int[] hargaMakanan = { 14000, 15000, 12000, 16000, 11000, 5000, 4000 };
    static String[] kelas = { "Ekonomi", "Bisnis", "Eksekutif" };
    static String[] kota = { "Jakarta", "Bandung", "Cirebon", "Purwokerto", "Semarang", "Yogyakarta", "Solo", "Kediri",
            "Malang", "Surabaya" };
    static String[] jenisIdentitas = { "KTP", "SIM", "Paspor", "Kartu Pelajar" };
    static String[] jenisKelamin = { "Laki-Laki", "Perempuan" };
    static boolean[][][] kursiTersedia = new boolean[kelas.length][kota.length][];
    static int hargaTiket[][][] = {
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
    static List<Pemesanan> riwayatPemesanan = new ArrayList<>();

    static class Pemesanan {
        String nama;
        int umur;
        String jenisKelamin;
        String identitas;
        String asal;
        String tujuan;
        String kelas;
        int harga;

        public Pemesanan(String nama, int umur, String jenisKelamin, String identitas, String asal, String tujuan,
                String kelas, int harga) {
            this.nama = nama;
            this.umur = umur;
            this.jenisKelamin = jenisKelamin;
            this.identitas = identitas;
            this.asal = asal;
            this.tujuan = tujuan;
            this.kelas = kelas;
            this.harga = harga;
        }

        public String toString() {
            return "Nama: " + nama + ", Umur: " + umur + ", Jenis Kelamin: " + jenisKelamin + ", Identitas: "
                    + identitas + ", Asal: " + asal + ", Tujuan: " + tujuan + ", Kelas: " + kelas + ", Harga: " + harga;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeKursi();

        int pilihmenu;

        do {
            System.out.println("=============================================================");
            System.out.println("========== SELAMAT DATANG DI SISTEM BOOKING KERETA ==========");
            System.out.println("=============================================================");

            System.out.println(
                    "\nDaftar Menu = \n1.Pesan Tiket\n2.Tampilkan Jadwal\n3.Tampilkan Harga\n4.Tampilkan Riwayat Pemesanan\n5.Exit");
            System.out.println("=============================================================");
            System.out.print("\nPilihan : ");
            pilihmenu = sc.nextInt();

            switch (pilihmenu) {
                case 1:
                    pemesananTiket();
                    break;
                case 2:
                    tampilkanJadwalKereta();
                    break;
                case 3:
                    tampilkanHargaTiket();
                    break;
                case 4:
                    tampilkanRiwayatPemesanan();
                    break;
                case 5:
                    System.out.println("=============================================================");
                    System.out.println("==============\t\tTERIMA KASIH\t\t=============");
                    System.out.println("=============================================================");
                    break;
                default:
                    System.out.println("=============== INPUT YANG ANDA MASUKKAN SALAH ==============\n\n");
            }
        } while (pilihmenu != 5);

        sc.close();
    }

    public static void pemesananTiket() {

        int pilihMenu;

        do {
            System.out.println("=============================================================");
            System.out.println("==============\t\tPESAN TIKET\t\t=============");
            System.out.println("=============================================================");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Cek Tempat Duduk");
            System.out.println("3. Kembali Ke Menu Utama");
            System.out.print("\nPilih Menu : ");
            pilihMenu = sc.nextInt();

            switch (pilihMenu) {
                case 1:
                    pesanTiket();
                    break;
                case 2:
                    cekTempatDuduk();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihMenu != 3);

    }

    static void pesanTiket() {

        int totalHarga = 0;
        System.out.print("Masukkan Nama : ");
        String nama = sc.next();
        System.out.print("Masukkan Umur : ");
        int umur = sc.nextInt();

        int indeksJenisKelamin;
        do {
            System.out.println("Jenis Kelamin : ");
            for (int i = 0; i < jenisKelamin.length; i++) {
                System.out.println((i + 1) + ". " + jenisKelamin[i]);
            }
            System.out.print("Pilih Jenis Kelamin (1-" + jenisKelamin.length + "): ");
            indeksJenisKelamin = sc.nextInt() - 1;

            if (indeksJenisKelamin < 0 || indeksJenisKelamin >= jenisKelamin.length) {
                System.out.println("Pilihan jenis kelamin tidak valid. Silakan pilih lagi.");
            }
        } while (indeksJenisKelamin < 0 || indeksJenisKelamin >= jenisKelamin.length);

        int pilihIdentitas;
        do {
            System.out.println("Jenis Identitas : ");
            for (int i = 0; i < jenisIdentitas.length; i++) {
                System.out.println((i + 1) + ". " + jenisIdentitas[i]);
            }
            System.out.print("Pilih Jenis Identitas (1-" + jenisIdentitas.length + "): ");
            pilihIdentitas = sc.nextInt() - 1;

            if (pilihIdentitas < 0 || pilihIdentitas >= jenisIdentitas.length) {
                System.out.println("Pilihan jenis identitas tidak valid. Silakan pilih lagi.");
            }
        } while (pilihIdentitas < 0 || pilihIdentitas >= jenisIdentitas.length);

        System.out.println("Kota Asal Keberangkatan : ");
        for (int i = 0; i < kota.length; i++) {
            System.out.println((i + 1) + ". " + kota[i]);
        }
        System.out.print("Pilih Kota Asal Keberangkatan (1-" + kota.length + "): ");
        int pilihAsal = sc.nextInt();

        System.out.println("Kota Tujuan : ");
        for (int i = 0; i < kota.length; i++) {
            System.out.println((i + 1) + ". " + kota[i]);
        }
        System.out.print("Pilih Kota Tujuan (1-" + kota.length + "): ");
        int pilihTujuan = sc.nextInt();

        while (pilihAsal == pilihTujuan || pilihAsal < 1 || pilihAsal > kota.length || pilihTujuan < 1
                || pilihTujuan > kota.length) {
            System.out.println("Salah input. Silakan pilih lagi.");

            System.out.print("Pilih Kota Asal Keberangkatan (1-" + kota.length + "): ");
            pilihAsal = sc.nextInt();

            System.out.print("Pilih Kota Tujuan (1-" + kota.length + "): ");
            pilihTujuan = sc.nextInt();
        }

        System.out.println("Kelas : ");
        for (int i = 0; i < kelas.length; i++) {
            System.out.println((i + 1) + ". " + kelas[i]);
        }
        System.out.print("Pilih Kelas (1-" + kelas.length + "): ");
        int pilihKelas = sc.nextInt();
        if (pilihKelas < 1 || pilihKelas > kelas.length) {
            System.out.println("Pilihan kelas tidak valid.");
            return;
        }
        System.out.print("Masukkan Jumlah Tiket yang Ingin Dibeli: ");
        int jumlahTiket = sc.nextInt();

        for (int i = 0; i < jumlahTiket; i++) {
            System.out.println("\nTiket ke-" + (i + 1));
            int hargaTiket = pilihTempatDuduk(pilihKelas - 1, pilihAsal - 1, pilihTujuan - 1);
            totalHarga += hargaTiket;
        }
        Pemesanan newBooking = new Pemesanan(
                nama,
                umur,
                jenisKelamin[indeksJenisKelamin],
                jenisIdentitas[pilihIdentitas],
                kota[pilihAsal - 1],
                kota[pilihTujuan - 1],
                kelas[pilihKelas - 1],
                totalHarga);
        riwayatPemesanan.add(newBooking);

        if (pilihAsal < 1 || pilihAsal > kota.length || pilihTujuan < 1 || pilihTujuan > kota.length || pilihKelas < 1
                || pilihKelas > kelas.length) {
            System.out.println("Pilihan tidak valid. Silakan ulangi.");
            return;
        }
        System.out.println("Apakah Anda ingin memesan makanan? (Ya/Tidak)");
        String jawaban = sc.next();
        if (jawaban.equalsIgnoreCase("Ya")) {
            totalHargaMakanan = pesanMakanan(); // Menyimpan total harga makanan
        }

        totalHarga += totalHargaMakanan;

        prosesPilihanKelas(nama, umur, jenisKelamin[indeksJenisKelamin], jenisIdentitas[pilihIdentitas],
                pilihAsal - 1, pilihTujuan - 1, pilihKelas - 1, totalHarga);
    }

    static int pesanMakanan() {
        System.out.println("\n================================");
        System.out.println("Menu Makanan:");

        // Menampilkan daftar menu makanan
        for (int i = 0; i < menuMakanan.length; i++) {
            System.out.println((i + 1) + ". " + menuMakanan[i] + " - Rp. " + hargaMakanan[i]);
        }

        System.out.println((menuMakanan.length + 1) + ". Kembali ke Menu Utama");
        System.out.println("================================");

        int totalHargaMakanan = 0; // Total harga makanan yang dipilih
        int jumlahMakanan = 0; // Jumlah makanan yang ingin dibeli

        while (true) {
            System.out.print("Pilih menu makanan (1-" + (menuMakanan.length + 1) + "): ");
            int pilihan = sc.nextInt();

            if (pilihan >= 1 && pilihan <= menuMakanan.length) {
                // Memasukkan jumlah makanan yang ingin dibeli
                System.out.print("Berapa banyak " + menuMakanan[pilihan - 1] + " yang ingin dibeli: ");
                int jumlah = sc.nextInt();

                // Menambahkan total harga makanan yang dipilih
                totalHargaMakanan += (hargaMakanan[pilihan - 1] * jumlah);

                // Menampilkan pesanan makanan
                System.out.println("Anda telah memesan " + jumlah + " " + menuMakanan[pilihan - 1] + ".");
                jumlahMakanan += jumlah;

                totalHarga += totalHargaMakanan;

                // Menampilkan total harga makanan sementara
                System.out.println("Total Harga Makanan Sementara: Rp. " + totalHargaMakanan);

            } else if (pilihan == menuMakanan.length + 1) {
                break; // Keluar dari menu makanan
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        }

        // Menambahkan total harga makanan ke totalHarga tiket
        totalHarga += totalHargaMakanan;

        // Menampilkan kembali menu utama
        System.out.println("================================");
        System.out.println("Kembali ke Menu Utama");
        System.out.println("================================");
        return totalHargaMakanan;
    }

    static void prosesPilihanKelas(String nama, int umur, String jenisKelamin, String pilihIdentitas,
            int pilihAsal, int pilihTujuan, int pilihKelas, int totalHarga) {
        tampilkanDaftarHarga(pilihKelas, pilihAsal, pilihTujuan);
        System.out.println("Harga Tiket : " + hargaTiket[pilihKelas][pilihAsal][pilihTujuan]);
        tampilkanDetailPesan(nama, umur, jenisKelamin, pilihIdentitas, kota[pilihAsal], kota[pilihTujuan], totalHarga);
    }

    static void tampilkanDaftarHarga(int pilihKelas, int pilihAsal, int pilihTujuan) {
        System.out.println("Daftar Harga Tiket " + kelas[pilihKelas]);
        for (int i = 0; i < kota.length; i++) {
            System.out.printf("%2d. %-10s", (i + 1), kota[i]);
            if ((i + 1) % 2 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
    }

    static int pilihTempatDuduk(int pilihKelas, int pilihAsal, int pilihTujuan) {
        System.out.print("Pilih Tempat Duduk (1 - 64): ");
        int nomorKursi = sc.nextInt();

        if (nomorKursi >= 1 && nomorKursi <= 64) {
            if (kursiTersedia[pilihKelas][pilihAsal][nomorKursi - 1]) {
                System.out.println("Tempat duduk tersedia. Silakan pesan tiket.");
                // Set the selected seat to unavailable
                kursiTersedia[pilihKelas][pilihAsal][nomorKursi - 1] = false;
                // Update the seat availability display
                tampilkanKursi(kursiTersedia[pilihKelas][pilihAsal]);

                // Mengembalikan harga tiket yang dipilih
                return hargaTiket[pilihKelas][pilihAsal][pilihTujuan];
            } else {
                System.out.println("Maaf, tempat duduk sudah dipesan. Pilih tempat lain.");
                return pilihTempatDuduk(pilihKelas, pilihAsal, pilihTujuan); // Pilih tempat lagi jika tidak tersedia
            }
        } else {
            System.out.println("Nomor kursi tidak valid. Silakan pilih nomor kursi antara 1 - 64.");
            return pilihTempatDuduk(pilihKelas, pilihAsal, pilihTujuan); // Pilih tempat lagi jika nomor tidak valid
        }
    }

    static void tampilkanDetailPesan(String nama, int umur, String jenisKelamin, String pilihIdentitas,
            String pilihAsal, String pilihTujuan, int totalHarga) {
        System.out.println("================================");
        System.out.println("Nama : " + nama);
        System.out.println("Umur : " + umur);
        System.out.println("Jenis Kelamin : " + jenisKelamin);
        System.out.println("Jenis Identitas : " + pilihIdentitas);
        System.out.println("Kota Asal Keberangkatan : " + pilihAsal);
        System.out.println("Kota Tujuan : " + pilihTujuan);
        System.out.println("Total Harga : " + totalHarga);
        System.out.println("================================\n");
    }

    static void initializeKursi() {
        for (int i = 0; i < kelas.length; i++) {
            for (int j = 0; j < kota.length; j++) {
                kursiTersedia[i][j] = generateKursi();
            }
        }
    }

    static void updateSeatDisplay(int pilihKelas, int pilihAsal) {
        System.out.println("===== " + kelas[pilihKelas] + " - " + kota[pilihAsal] + " =====");
        tampilkanKursi(kursiTersedia[pilihKelas][pilihAsal]);
    }

    static boolean[] generateKursi() {
        boolean[] kursi = new boolean[64];
        Arrays.fill(kursi, true); // Mengatur semua kursi menjadi tersedia
        return kursi;
    }

    static void cekTempatDuduk() {
        for (int i = 0; i < kota.length; i++) {
            System.out.printf("%2d. %-10s", (i + 1), kota[i]);
            if ((i + 1) % 2 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
        System.out.print("Masukkan kota (1 - 10): ");
        int pilihKota = sc.nextInt() - 1;
        for (int i = 0; i < kelas.length; i++) {
            System.out.println((i + 1) + ". " + kelas[i]);
        }
        System.out.print("Masukkan kelas (1 - 3): ");
        int pilihKelas = sc.nextInt() - 1;

        if (isValidInput(pilihKota, pilihKelas)) {
            System.out.println("===== " + kelas[pilihKelas] + " - " + kota[pilihKota] + " =====");
            tampilkanKursi(kursiTersedia[pilihKelas][pilihKota]);
            // pilihTempatDuduk(pilihKelas, pilihKota); // Tidak perlu memanggil ini di sini
        } else {
            System.out.println("Input tidak valid. Program berhenti.");
        }
    }

    static boolean isValidInput(int pilihKota, int pilihKelas) {
        return (pilihKota >= 0 && pilihKota < kota.length) && (pilihKelas >= 0 && pilihKelas < kelas.length);
    }

    static void isiTempatDuduk(int pilihKelas, int pilihAsal, int pilihTujuan) {
        System.out.print("Pilih Tempat Duduk (1 - 64): ");
        int nomorKursi = sc.nextInt();

        if (nomorKursi >= 1 && nomorKursi <= 64) {
            if (kursiTersedia[pilihKelas][pilihAsal][nomorKursi - 1]) {
                System.out.println("Tempat duduk tersedia. Silakan pesan tiket.");
                // Set the selected seat to unavailable
                kursiTersedia[pilihKelas][pilihAsal][nomorKursi - 1] = false;
                // Update the seat availability display
                tampilkanKursi(kursiTersedia[pilihKelas][pilihAsal]);
            } else {
                System.out.println("Maaf, tempat duduk sudah dipesan. Pilih tempat lain.");
            }
        } else {
            System.out.println("Nomor kursi tidak valid.");
        }
    }

    static void tampilkanKursi(boolean[] kursiTersedia) {
        for (int i = 0; i < kursiTersedia.length; i++) {
            if (kursiTersedia[i]) {
                System.out.print("O "); // Kursi tersedia
            } else {
                System.out.print("X "); // Kursi tidak tersedia
            }

            if ((i + 1) % 8 == 0) {
                System.out.println();
            } else if ((i + 1) % 2 == 0) {
                System.out.print("\t");
            }
        }

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

            //

            System.out.println("\n1. Kembali ke Menu Utama\n2. Kembali Melihat daftar Harga Lain");
            System.out.print("\nPilihan : ");
            pilihTampilkanJadwal = sc.nextInt();

            //
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
        } while (pilihKota < 1 || pilihKota > kota.length || pilihKelas < 1 || pilihKelas > kelas.length
                || pilihTampilkanJadwal == 2);
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

    public static void tampilkanRiwayatPemesanan() {
        System.out.println("\n================================");
        System.out.println("Riwayat Pemesanan:");
        for (Pemesanan pemesanan : riwayatPemesanan) {
            System.out.println(pemesanan);
        }
        System.out.println("================================\n");
    }
}
