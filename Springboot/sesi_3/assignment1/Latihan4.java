public class Latihan4 {
    public static void main(String[] args) {
        int a=10;
        int b=8;
        int c=12;
        int d=5;
        boolean hasil;

        hasil= a > b;
        System.out.println("Tes ke 1 = " +hasil);
        hasil= d < b;
        System.out.println("Tes ke 2 = "+hasil);
        hasil= a >= d;
        System.out.println("Tes ke 3 = "+hasil);
        hasil= b <= c;
        System.out.println("Tes ke 4 = "+hasil);
        hasil= a%b == c%d;
        System.out.println("Tes ke 5 = "+hasil);
        hasil= b != d;
        System.out.println("Tes ke 6 = "+hasil);
        hasil= b > a;
        System.out.println("Tes ke 7 = "+hasil);
        hasil= c <= d;
        System.out.println("Tes ke 8 = "+hasil);
        hasil= a == d;
        System.out.println("Tes ke 9 = "+hasil);
        hasil= a+d != c+3;
        System.out.println("Tes ke 10 = "+hasil);
    }
}
