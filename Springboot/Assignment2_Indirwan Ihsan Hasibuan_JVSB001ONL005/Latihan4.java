import java.util.Scanner;

public class Latihan4{
  
    public static void main(String[] args) {
        
        int tahun;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("!!CEK TAHUN KABISAT!!");
        System.out.print("Masukkan tahun yang ingin di cek : ");
        tahun = scan.nextInt();
        if (tahun % 400 == 0) {
            System.out.print("Merupakan Tahun Kabisat\n");
        } else if (tahun % 100 == 0) {
            System.out.print("Bukan Tahun Kabisat\n");
        } else if (tahun % 4 == 0) {
            System.out.print("Merupakan Tahun Kabisat\n");
        } else {
            System.out.print("Bukan Tahun Kabisat\n");
        }
  }
}