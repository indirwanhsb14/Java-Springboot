import java.util.Scanner;

public class Hadiah {
    
    public static void main(String[] args) {
        
        //Membuat variabel belanja dan scanner
        int belanja = 0;
        Scanner scan = new Scanner(System.in);

        //Mengambil Input
        System.out.print("Total belanjaan: Rp");
        belanja = scan.nextInt();

        //Cek apakah dia belanja diatas 100000
        if(belanja > 100000){
            System.out.println("Selamat anda mendapatkan hadiah!");
        }

        System.out.println("Terima Kasih!");
    }
}
