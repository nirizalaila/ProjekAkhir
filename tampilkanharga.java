import java.util.Scanner;

public class tampilkanharga {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kelas[] = { "Ekonomi", "Bisnis", "Eksekutif" };
        int hargaTiketEkonomi[][] = { { 0, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000 },
                { 100000, 0, 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000 },
                { 150000, 50000, 0, 50000, 100000, 150000, 200000, 250000, 300000, 350000 },
                { 200000, 100000, 50000, 0, 50000, 100000, 150000, 200000, 250000, 300000 },
                { 250000, 150000, 100000, 50000, 0, 50000, 100000, 150000, 200000, 250000 },
                { 300000, 200000, 150000, 100000, 50000, 0, 50000, 100000, 150000, 200000 },
                { 350000, 250000, 200000, 150000, 100000, 50000, 0, 50000, 100000, 150000 },
                { 400000, 300000, 250000, 200000, 150000, 100000, 50000, 0, 50000, 100000 },
                { 450000, 350000, 300000, 250000, 200000, 150000, 100000, 50000, 0, 50000 },
                { 500000, 400000, 350000, 300000, 250000, 200000, 150000, 100000, 50000, 0 } };

        int hargaTiketBisnis[][] = { { 0, 160000, 210000, 260000, 310000, 360000, 410000, 460000, 510000, 560000 },
                { 160000, 0, 110000, 160000, 210000, 260000, 310000, 360000, 410000, 460000 },
                { 210000, 110000, 0, 110000, 160000, 210000, 260000, 310000, 360000, 410000 },
                { 260000, 160000, 110000, 0, 110000, 160000, 210000, 260000, 310000, 360000 },
                { 310000, 210000, 160000, 110000, 0, 110000, 160000, 210000, 260000, 310000 },
                { 360000, 260000, 210000, 160000, 110000, 0, 110000, 160000, 210000, 260000 },
                { 410000, 310000, 260000, 210000, 160000, 110000, 0, 110000, 160000, 210000 },
                { 460000, 360000, 310000, 260000, 210000, 160000, 110000, 0, 110000, 160000 },
                { 510000, 410000, 360000, 310000, 260000, 210000, 160000, 110000, 0, 110000 },
                { 560000, 460000, 410000, 360000, 310000, 260000, 210000, 160000, 110000, 0 } };

        int hargaTiketEksekutif[][] = { { 0, 250000, 300000, 350000, 400000, 450000, 500000, 550000, 600000, 650000 },
                { 250000, 0, 200000, 250000, 300000, 350000, 400000, 450000, 500000, 550000 },
                { 300000, 200000, 0, 150000, 200000, 250000, 300000, 350000, 400000, 450000 },
                { 350000, 250000, 150000, 0, 200000, 250000, 300000, 350000, 400000, 450000},
                { 400000, 300000, 200000, 150000, 0, 200000, 250000, 300000, 350000, 400000 },
                { 450000, 350000, 300000, 250000, 200000, 0, 200000, 250000, 300000, 350000 },
                { 500000, 400000, 350000, 300000, 250000, 200000, 0, 200000, 250000, 300000 },
                { 550000, 450000, 400000, 350000, 300000, 250000, 200000, 0, 200000, 250000 },
                { 600000, 500000, 450000, 400000, 350000, 300000, 250000, 200000, 0, 200000 },
                { 650000, 550000, 500000, 450000, 400000, 350000, 300000, 250000, 200000, 0 } };


        System.out.println("================================");
        System.out.println("==== Tampilkan Harga Tiket  ====");
        System.out.println("================================");
        String kota[] = { "Jakarta", "Bandung", "Cirebon", "Purwokerto", "Semarang", "Yogyakarta", "Solo", "Kediri",
                "Malang", "Surabaya" };
        for (int i = 0; i < kota.length; i++) {
            System.out.printf("%2d. %-10s", (i + 1), kota[i]);
            if ((i + 1) % 2 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
        System.out.print("\nPilih Kota : ");
        int pilihKota = sc.nextInt();
        System.out.println("\nDaftar Kelas : ");
        for (int i = 0; i < kelas.length; i++) {
            System.out.println((i + 1) + ". " + kelas[i]);
        }
        System.out.println("\nPilih Kelas   : ");
        int pilihKelas = sc.nextInt();
        int[][] hargaTiket;

        if (pilihKelas == 1) {
            hargaTiket = hargaTiketEkonomi;
        } else if (pilihKelas == 2) {
            hargaTiket = hargaTiketBisnis;
        } else if (pilihKelas == 3) {
            hargaTiket = hargaTiketEksekutif;
        } else {
            System.out.println("Kelas tidak valid");
            return;
        }

        System.out.println("\nPilihan Kota   : " + kota[pilihKota - 1]);


        if (pilihKelas == 1) {
            hargaTiket = hargaTiketEkonomi;
        } else if (pilihKelas == 2) {
            hargaTiket = hargaTiketBisnis;
        } else if (pilihKelas == 3) {
            hargaTiket = hargaTiketEksekutif;
        } else {
            System.out.println("Invalid input for class selection!");
            return;
        }

        System.out.println("\nPilihan Kota   : " + kota[pilihKota - 1]);
        System.out.println("Pilihan Kelas  : " + kelas[pilihKelas - 1]);

        if (kota[pilihKota - 1].equals("Jakarta") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Jakarta ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Jakarta")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[0][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Jakarta") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Jakarta ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Jakarta")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[0][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Jakarta") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Jakarta ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Jakarta")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[0][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Bandung") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Bandung ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Bandung")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[1][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Bandung") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Bandung ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Bandung")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[1][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Bandung") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Bandung ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Bandung")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[1][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Cirebon") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Cirebon ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Cirebon")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[2][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Cirebon") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Cirebon ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Cirebon")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[2][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Cirebon") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Cirebon ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Cirebon")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[2][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Purwokerto") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Purwokerto ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Purwokerto")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[3][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Purwokerto") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Purwokerto ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Purwokerto")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[3][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Purwokerto") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Purwokerto ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Purwokerto")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[3][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Semarang") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Semarang ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Semarang")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[4][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Semarang") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Semarang ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Semarang")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[4][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Semarang") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Semarang ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Semarang")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[4][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Yogyakarta") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Yogyakarta ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Yogyakarta")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[5][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Yogyakarta") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Yogyakarta ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Yogyakarta")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[5][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Yogyakarta") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Yogyakarta ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Yogyakarta")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[5][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Solo") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Solo ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Solo")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[6][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Solo") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Solo ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Solo")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[6][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Solo") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Solo ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Solo")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[6][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Kediri") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Kediri ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Kediri")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[7][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Kediri") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Kediri ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Kediri")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[7][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Kediri") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Kediri ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Kediri")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[7][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Malang") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Malang ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Malang")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[8][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Malang") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Malang ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Malang")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[8][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Malang") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Malang ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Malang")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[8][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Surabaya") && kelas[pilihKelas - 1].equals("Ekonomi")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Surabaya ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Surabaya")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEkonomi[9][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Surabaya") && kelas[pilihKelas - 1].equals("Bisnis")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Surabaya ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Surabaya")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketBisnis[9][i]);
                }
            }
        }
        else if (kota[pilihKota - 1].equals("Surabaya") && kelas[pilihKelas - 1].equals("Eksekutif")) {
            System.out.println("\nHarga Tiket " + kelas[pilihKelas-1] +" dari Surabaya ke kota lain:");

            for (int i = 0; i < kota.length; i++) {
                if (!kota[i].equals("Surabaya")) {
                    System.out.println("Ke " + kota[i] + ": " + hargaTiketEksekutif[9][i]);
                }
            }
        }
        else {
            System.out.println("Kota tidak valid");
            return;
        }
    }
}
