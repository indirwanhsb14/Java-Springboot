import java.util.Scanner;

public class SelectionSorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int jlhData;

        System.out.print("Masukkan jumlah input: ");
        jlhData = scan.nextInt();

        int[] data = new int[jlhData];

        for (int i = 0; i < jlhData; i++) {
            System.out.print("Masukkan nilai data ke-" + (i + 1) + " : ");
            data[i] = scan.nextInt();
        }

        System.out.println();

        System.out.println("Data Sebelum di Sorting : ");
        for (int i = 0; i < jlhData; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println("\n\nProses Selection Sort");

        for (int i = 0; i < jlhData - 1; i++) {
            System.out.println("Iterasi ke-" + (i + 1));
            for (int j = 0; j < jlhData; j++) {
                System.out.print(data[j] + " ");
            }

           System.out.println("Apakah data " + data[i] + " sudah pada tempatnya?");

            boolean tukar = false;
            int min = data[i];
            int indeks = 0;
            String pesan = " Tidak ada pertukaran";
            for (int k = i + 1; k < jlhData; k++) {
                if (min > data[k]) {
                    tukar = true;
                    indeks = k;
                    min = data[k];
                }
            }

            if (tukar) {
               pesan = "Data " + data[i] + " ditukar dengan " + data[indeks];
                int temp = data[i];
                data[i] = data[indeks];
                data[indeks] = temp;
            }

            for (int j = 0; j < jlhData; j++) {
                System.out.print(data[j] + " ");
            }

            System.out.println(pesan + "\n");

        }

    }
}