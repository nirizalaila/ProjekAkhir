import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class proyekcoba {

    static Scanner sc = new Scanner(System.in);
    static int totalHarga = 0;
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
    static double[][] jarak = {
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

    // list untuk menyimpan riwayat pemesanan
    static List<Pemesanan> riwayatPemesanan = new ArrayList<>();

    // class untuk menyimpan data pemesanan riwayat pemesanan
    static class Pemesanan {
        String nama;
        int umur;
        String jenisKelamin;
        String identitas;
        String asal;
        String tujuan;
        String kelas;
        int totalHarga;
        String nomorPembelian;
        String jadwalKeberangkatan;

        // constructor untuk class Pemesanan
        public Pemesanan(String nama, int umur, String jenisKelamin, String identitas, String asal, String tujuan,
                String kelas, int totalHarga, String nomorPembelian, String jadwalKeberangkatan) {
            this.nama = nama;
            this.umur = umur;
            this.jenisKelamin = jenisKelamin;
            this.identitas = identitas;
            this.asal = asal;
            this.tujuan = tujuan;
            this.kelas = kelas;
            this.totalHarga = totalHarga;
            this.nomorPembelian = nomorPembelian;
            this.jadwalKeberangkatan = jadwalKeberangkatan;
        }

        // method untuk menampilkan data pemesanan ke riwayat pemesanan
        public String toString() {
            return "\nNama\t\t\t: " + nama + "\nUmur\t\t\t: " + umur + "\nJenis Kelamin\t\t: " + jenisKelamin
                    + "\nIdentitas\t\t: "
                    + identitas + "\nAsal\t\t\t: " + asal + "\nTujuan\t\t\t: " + tujuan + "\nKelas\t\t\t: " + kelas
                    + "\nTotal Harga \t\t: " + "Rp."
                    + totalHarga + "\nNomor Pembelian Tiket\t: " + nomorPembelian + "\nJadwal Keberangkatan\t: " + jadwalKeberangkatan
                    + "\n========================";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inisialKursi();

        int pilihmenu; int pilihBahasa;

        do {
            System.out.println("=============================================================");
            System.out.println("========== SELAMAT DATANG DI SISTEM BOOKING KERETA ==========");
            System.out.println("=============================================================");
            System.out.println();
            System.out.println("Pilih Bahasa :");
            System.out.println("1. Indonesia\n2. English");
            System.out.print("Pilihan (1-2) : ");
            pilihBahasa = sc.nextInt();

            switch (pilihBahasa) {
                case 1:
                int pilihanMenu;
                do {
                    pilihanMenu = tampilkanMenuUtama();
                    switch (pilihanMenu) {
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
                            cetakStrukID();
                            break;
                        case 6:
                            System.out.println("=============================================================");
                            System.out.println("==============\t\tTERIMA KASIH\t\t=============");
                            System.out.println("=============================================================");
                            System.exit(0); // agar keluar dari program secara langsung
                            break;
                        default:
                            System.out.println("=============== INPUT YANG ANDA MASUKKAN SALAH ==============\n\n");
                    }
                } while (pilihanMenu != 6);
                
                    break;
                case 2:
                    System.out.println("Sorry, this feature is not available yet.");
                    break;
                default:
                    break;
            }
        } while (true);
    }
    static int tampilkanMenuUtama() {
        System.out.println(
                "\nDaftar Menu = \n1.Pesan Tiket\n2.Tampilkan Jadwal\n3.Tampilkan Harga\n4.Tampilkan Riwayat Pemesanan\n5.Cetak Struk\n6.Keluar");
        System.out.println("=============================================================");
        System.out.print("\nPilihan : ");
        return sc.nextInt();
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

        Random random = new Random();

        // Set karakter yang diizinkan untuk bagian huruf
        String hurufHuruf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Generate nomor acak
        int acakNomor = random.nextInt(1000000000); // Nomor acak antara 0 - 999999999
        // Generate huruf acak
        char hurufAcak = hurufHuruf.charAt(random.nextInt(hurufHuruf.length()));
        // Gabungkan nomor acak dan huruf acak
        String nomorPembelian = hurufAcak + String.valueOf(acakNomor);

        int totalHargaMakanan = 0;
        int totalHarga = 0;
        int indeksJenisKelamin;
        int pilihIdentitas;
        System.out.print("Masukkan Umur : ");
        int umur = sc.nextInt();
        sc.nextLine(); // untuk menghindari bug
        System.out.print("Masukkan Nama : ");
        String nama = sc.nextLine();

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

        String jadwalKeberangkatan = hitungJadwalKeberangkatan(pilihKelas - 1, pilihAsal - 1, pilihTujuan - 1);

        Pemesanan newBooking = new Pemesanan(
                nama,
                umur,
                jenisKelamin[indeksJenisKelamin],
                jenisIdentitas[pilihIdentitas],
                kota[pilihAsal - 1],
                kota[pilihTujuan - 1],
                kelas[pilihKelas - 1],
                totalHarga,
                nomorPembelian,
                jadwalKeberangkatan);
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
        newBooking.totalHarga = totalHarga;

        prosesPilihanKelas(nama, umur, jenisKelamin[indeksJenisKelamin], jenisIdentitas[pilihIdentitas],
                pilihAsal - 1, pilihTujuan - 1, pilihKelas - 1, totalHarga, nomorPembelian);
    }

    //
    static int pesanMakanan() {
        String nomorPembelian;
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

                // Menambahkan total harga makanan yang dipilih ke variabel statis di kelas
                // utama
                totalHargaMakanan += (hargaMakanan[pilihan - 1] * jumlah);

                // Menampilkan pesanan makanan
                System.out.println("Anda telah memesan " + jumlah + " " + menuMakanan[pilihan - 1] + ".");
                jumlahMakanan += jumlah;

                // Menampilkan total harga makanan sementara
                System.out.println("Total Harga Makanan Sementara: Rp. " + totalHargaMakanan);

            } else if (pilihan == menuMakanan.length + 1) {
                break; // Keluar dari menu makanan
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        }

        // Menambahkan total harga makanan ke totalHarga tiket di kelas utama
        totalHarga += totalHargaMakanan;

        // Menampilkan kembali menu utama
        System.out.println("================================");
        System.out.println("Kembali ke Menu Utama");
        System.out.println("================================");
        return totalHargaMakanan;
    }

    static void prosesPilihanKelas(String nama, int umur, String jenisKelamin, String pilihIdentitas,
            int pilihAsal, int pilihTujuan, int pilihKelas, int totalHarga, String nomorPembelian) {
        tampilkanDaftarHarga(pilihKelas, pilihAsal, pilihTujuan);
        System.out.println("Harga Tiket : " + hargaTiket[pilihKelas][pilihAsal][pilihTujuan]);
        tampilkanDetailPesan(nama, umur, jenisKelamin, pilihIdentitas, kota[pilihAsal], kota[pilihTujuan], totalHarga,
                nomorPembelian);
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

    // Method untuk menampilkan riwayat pemesanan
    static void tampilkanDetailPesan(String nama, int umur, String jenisKelamin, String pilihIdentitas,
            String pilihAsal, String pilihTujuan, int totalHarga, String nomorPembelian) {
        System.out.println("================================");
        System.out.println("Nama \t\t\t: " + nama);
        System.out.println("Umur \t\t\t: " + umur);
        System.out.println("Jenis Kelamin \t\t: " + jenisKelamin);
        System.out.println("Jenis Identitas \t: " + pilihIdentitas);
        System.out.println("Kota Asal Keberangkatan : " + pilihAsal);
        System.out.println("Kota Tujuan \t\t: " + pilihTujuan);
        System.out.println("Total Harga \t\t: " + "Rp." + totalHarga);
        System.out.println("Nomor Pembelian Tiket\t: " + nomorPembelian);
        System.out.println("================================\n");
    }

    // Method untuk memilih tempat duduk
    static int pilihTempatDuduk(int pilihKelas, int pilihAsal, int pilihTujuan) {
        System.out.print("Pilih Tempat Duduk (1 - 64): ");
        int nomorKursi = sc.nextInt();

        if (nomorKursi >= 1 && nomorKursi <= 64) {
            if (kursiTersedia[pilihKelas][pilihAsal][nomorKursi - 1]) {
                System.out.println("Tempat duduk tersedia. Silakan pesan tiket.");
                // untuk mengubah status kursi menjadi tidak tersedia
                kursiTersedia[pilihKelas][pilihAsal][nomorKursi - 1] = false;
                // untuk menampilkan kursi yang tersedia
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

    static String hitungJadwalKeberangkatan(int pilihKelas, int pilihAsal, int pilihTujuan) {
        double kecepatan = (pilihKelas == 0) ? 80 : ((pilihKelas == 1) ? 90 : 100); // Perhatikan indeks kelas
        double jarakTempuh = jarak[pilihAsal][pilihTujuan];
        double waktuTempuh = jarakTempuh / kecepatan;
        int jamMulai = 8; // Misalnya, semua kereta berangkat pada jam 8 pagi
        int[] waktuSelesai = hitungWaktuSelesai(jamMulai, waktuTempuh);
        return String.format("%02d:%02d - %02d:%02d", jamMulai, 0, waktuSelesai[0], waktuSelesai[1]);
    }

    // Method untuk menginisialisasi kursi yang tersedia
    static void inisialKursi() {
        for (int i = 0; i < kelas.length; i++) {
            for (int j = 0; j < kota.length; j++) {
                kursiTersedia[i][j] = new boolean[64]; // inisialisasi array kursi
                for (int k = 0; k < kursiTersedia[i][j].length; k++) {
                    kursiTersedia[i][j][k] = true; // mengatur semua kursi menjadi tersedia
                }
            }
        }
    }

    // Method untuk mengecek tempat duduk
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

    // Method untuk mengecek apakah input valid
    static boolean isValidInput(int pilihKota, int pilihKelas) {
        return (pilihKota >= 0 && pilihKota < kota.length) && (pilihKelas >= 0 && pilihKelas < kelas.length);
    }

    // Method untuk mengisi tempat duduk
    static void isiTempatDuduk(int pilihKelas, int pilihAsal, int pilihTujuan) {
        System.out.print("Pilih Tempat Duduk (1 - 64): ");
        int nomorKursi = sc.nextInt();

        // Validasi nomor kursi
        if (nomorKursi >= 1 && nomorKursi <= 64) {
            if (kursiTersedia[pilihKelas][pilihAsal][nomorKursi - 1]) {
                System.out.println("Tempat duduk tersedia. Silakan pesan tiket.");
                // Untuk mengubah status kursi menjadi tidak tersedia
                kursiTersedia[pilihKelas][pilihAsal][nomorKursi - 1] = false;
                // Untuk menampilkan kursi yang tersedia
                tampilkanKursi(kursiTersedia[pilihKelas][pilihAsal]);
            } else {
                System.out.println("Maaf, tempat duduk sudah dipesan. Pilih tempat lain.");
            }
        } else {
            System.out.println("Nomor kursi tidak valid.");
        }
    }

    // Method untuk menampilkan kursi yang tersedia dan Mengubah Posisi
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

    // Method untuk menampilkan jadwal kereta
    public static void tampilkanJadwalKereta() {

        // Pilih kota dan kelas
        int pilihKota;
        int pilihKelas;
        int pilihTampilkanJadwal = 0;
        do {
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
            do {
                System.out.println("================================");
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
            } while (pilihKota < 1 || pilihKota > kota.length || pilihKelas < 1 || pilihKelas > kelas.length);

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

            System.out.println("\n1. Kembali ke Menu Utama\n2. Kembali Melihat daftar Jadwal Lain");
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
    public static int[] hitungWaktuSelesai(int jamMulai, double waktu) {
        int totalMenit = (int) (waktu * 60);
        int menitSelesai = (jamMulai * 60 + totalMenit) % (24 * 60);
        return new int[] { menitSelesai / 60, menitSelesai % 60 };
    }

    public static void tampilkanHargaTiket() {
        System.out.println("================================");
        System.out.println("==== Tampilkan Harga Tiket  ====");
        System.out.println("================================");

        // Tampilkan daftar kota
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
            // Tampilkan daftar kelas
            System.out.println("\n================================");
            System.out.println("Daftar Kelas : ");
            for (int i = 0; i < kelas.length; i++) {
                System.out.println((i + 1) + ". " + kelas[i]);
            }
            System.out.println("================================");

            System.out.print("\nPilih Kelas   : ");
            pilihKelas = sc.nextInt();
            // Validasi input kota dan kelas
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

    // Method untuk menampilkan riwayat pemesanan
    public static void tampilkanRiwayatPemesanan() {
        System.out.println("\n================================");
        System.out.println("Riwayat Pemesanan:");
        for (Pemesanan pemesanan : riwayatPemesanan) {
            System.out.println(pemesanan);
        }
        System.out.println("================================\n");
    }

    // Method untuk mencetak struk
    public static void cetakStrukID() {
        System.out.println("\n================================");
        System.out.println("Cetak Struk Pemesanan:");
        System.out.println("================================\n");

        System.out.print("Masukkan Nomor Pembelian Tiket : ");
        String nomorPembelian = sc.next();
        boolean cari = false;

        for (Pemesanan pemesanan : riwayatPemesanan) {
            if (pemesanan.nomorPembelian.equals(nomorPembelian)) {
                System.out.println(pemesanan);
                cari = true;
                break; // Tidak perlu mencari lagi
            }
        }
        if (!cari) {
            System.out.println("\n- Nomor Pembelian Tiket Tidak Ditemukan -");
        }
        System.out.println("================================\n");
    }
}