import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        double Luas;
        double P1 = 3.14;
        int r;
        Scanner scan = new Scanner(System.in);
        System.out.println("==================");
        System.out.print("input nilai r: ");
        r= scan.nextInt();

        Luas = P1 * r *r;
        System.out.println("Luas : "+ Luas);
        System.out.println("==================");
    }
}