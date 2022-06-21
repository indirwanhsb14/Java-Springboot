import java.util.Scanner;

public class ITProfesi{
    public static void main(String[] args) {
        
        //Membuat arrat IT Profesi
        String[] ITProfesi = new String[5];

        //Membuat Scanner
        Scanner scan = new Scanner(System.in);

        //Mengisi Data ke Array
        for(int i = 0; i < ITProfesi.length; i++){
            System.out.print("Buah ke-" + i + ": ");
            ITProfesi[i] = scan.nextLine();
        }

        System.out.println("============================");

        //Menampilkan semua isi array
        for(String b : ITProfesi){
            System.out.println(b);
        }
    }
}

