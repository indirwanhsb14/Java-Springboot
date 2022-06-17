import java.util.Scanner;
public class Latihan1 {
    
    public static void main(String args[])
    {
        Scanner masuk = new Scanner(System.in);
        int x, y, z, n;
        float jum, rata;
        n = 3;
        jum=0;
    
        System.out.println("Menentukan Bilangan Terbesar, Terkecil dan Rata-rata");
        System.out.println(" ");
        System.out.print("Masukkan bilangan pertama (X)    : ");
        x = masuk.nextInt();
        System.out.print("Masukkan bilangan kedua (Y)      : ");
        y = masuk.nextInt();
        System.out.print("Masukkan bilangan ketiga (Z)     : ");
        z = masuk.nextInt();

        jum = x + y +z;
        rata = jum / n;

        float maxOfNumbs = Math.max(x, Math.max(y, z));
        float minOfNumbs = Math.min(x, Math.min(y, z));
        
        System.out.println(" ");
        System.out.println("Hasil:");
        System.out.println("Rata-rata nya adalah: "+rata);
        System.out.println(maxOfNumbs + " adalah bilangan terbesar");
        System.out.println(+minOfNumbs + " adalah bilangan terkecil");
   }
}