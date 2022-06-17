import java.util.Scanner;

public class Latihan5AB {
    public static void main(String[] args) {
        int y1,y2,x1,x2;
        boolean hasil;
        Scanner scan = new Scanner(System.in);

        System.out.print("Input nilai y1: ");
        y1= scan.nextInt();
        System.out.print("Input nilai y2: ");
        y2= scan.nextInt();

        //Proses 5.A
        x1= (y1+y2)*(y1+y2);
        x2= (y1%4) * y2;

        System.out.println("x1= "+x1);
        System.out.println("x2= "+x2);

        //Proses 5.B
        hasil= x1 >= x2;
        System.out.println(hasil);

        hasil= x2>=x1;
        System.out.println(hasil);

        hasil=((x1%4)==(++x2%5));
        System.out.println(hasil);


    }
}
