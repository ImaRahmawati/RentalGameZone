package rentalgamezone;

import java.util.Scanner;

public class RentalGameZone {

    public static int hitungBiayaSewa(int hargaPerJam, int durasi) {
        return hargaPerJam * durasi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char transaksiBaru = 'T';

        do {
            System.out.println("==========================================");
            System.out.println("          GAMEZONE RENTAL PS              ");
            System.out.println("==========================================");

            System.out.print("Nama Pelanggan: ");
            String namaPelanggan = scanner.nextLine();

            System.out.println("\n1. PlayStation 4 - Rp8000/jam");
            System.out.println("2. PlayStation 5 - Rp12000/jam");
            System.out.print("Pilihan: ");
            int pilihanKonsol = scanner.nextInt();

            String namaKonsol = "";
            int hargaPerJam = 0;

            if (pilihanKonsol == 1) {
                namaKonsol = "PlayStation 4";
                hargaPerJam = 8000;
            } else if (pilihanKonsol == 2) {
                namaKonsol = "PlayStation 5";
                hargaPerJam = 12000;
            } else {
                System.out.println("Pilihan konsol tidak valid!");
                scanner.nextLine(); // Clear buffer
                System.out.println();
                continue;
            }

            System.out.print("Lama Bermain: ");
            int durasi = scanner.nextInt();

            if (durasi <= 0) {
                System.out.println("Lama bermain harus berupa bilangan bulat positif!");
                scanner.nextLine(); // Clear buffer
                System.out.println();
                continue;
            }

            System.out.print("Tambah Minuman (Y/T): ");
            char tambahMinuman = scanner.next().toUpperCase().charAt(0);

            int biayaSewa = hitungBiayaSewa(hargaPerJam, durasi);

            int diskon = 0;
            if (durasi >= 3) {
                diskon = (int) (biayaSewa * 0.10);
            }

            int biayaMinuman = 0;
            if (tambahMinuman == 'Y') {
                biayaMinuman = 5000;
            }

            int totalBayar = (biayaSewa - diskon) + biayaMinuman;

            System.out.println("\n==========================================");
            System.out.println("STRUK GAMEZONE");
            System.out.println("Pelanggan       : " + namaPelanggan);
            System.out.println("Konsol          : " + namaKonsol);
            System.out.println("Durasi          : " + durasi + " jam");
            System.out.println("Biaya Sewa      : Rp" + biayaSewa);
            System.out.println("Diskon (10%)    : Rp" + diskon);
            System.out.println("Minuman         : Rp" + biayaMinuman);
            System.out.println("TOTAL BAYAR     : Rp" + totalBayar);
            System.out.println("==========================================");

            System.out.print("Transaksi Baru (Y/T): ");
            transaksiBaru = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine();
            System.out.println();

        } while (transaksiBaru == 'Y');

        System.out.println("Terima kasih!");
        scanner.close();
    }
}