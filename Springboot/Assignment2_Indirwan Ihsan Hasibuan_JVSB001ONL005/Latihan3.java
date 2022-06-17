import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
       
        int beli;
        int diskon;
        int bayar;
       
        System.out.println("Selamat Datang di Indomaret.");
        System.out.print("Pembelian Rp.: ");
        beli=input.nextInt();
        
        
        if(beli >= 1000000){
            diskon = beli * 10/100;
            bayar = beli - diskon;
            System.out.println ("Total Harga Bayar : Rp."+bayar);
            System.out.println("Anda mendapatkan diskon 10%");
        } else {
            System.out.println ("Total Harga Bayar : Rp."+beli);
            System.out.println("Anda tidak mendapatkan diskon");
        }   
    }
}