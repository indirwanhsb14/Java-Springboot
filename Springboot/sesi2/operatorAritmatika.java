import java.util.Scanner;

public class operatorAritmatika {
    public static void main(String[] args) {
        //int a = 2;
        //int b = 1;
        //int tambah, kurang, kali, bagi, sisaPembagian;

        //tambah = a + b;
        //kurang = a - b;
        //kali = a * b;
        //bagi = a / b;
        //sisaPembagian = a % b;

        int angka1;
        int angka2;
        int hasil;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.print("Input angka-2: ");
        angka2 = keyboard.nextInt();

        //penjumlahan
        hasil = angka1 + angka2;
        System.out.println("Hasil = " + hasil);

        System.out.print("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.print("Input angka-2: ");
        angka2 = keyboard.nextInt();

        //pengurangan
        hasil = angka1 - angka2;
        System.out.println("Hasil = " + hasil);

        System.out.print("Input angka-1: ");
        angka1 = keyboard.nextInt();
        System.out.print("Input angka-2: ");
        angka2 = keyboard.nextInt();

        //perkalian
        hasil = angka1 * angka2;
        System.out.println("Hasil = " + hasil);
        
        System.out.print("Input angka-1: " );
        angka1 = keyboard.nextInt();
        System.out.print("Input angka-2: ");

        //pembagian
        hasil = angka1 / angka2;
        System.out.println("Hasil = " + hasil);

        System.out.print("Input angka-1: " );
        angka1 = keyboard.nextInt();
        System.out.print("Input angka-2: ");

        //Sisa Bagi
        hasil = angka1 % angka2;
        System.out.println("Hasil = " + hasil);
    }
}
