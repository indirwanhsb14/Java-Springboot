public class CetakOverloading {
    static double maxNumber(double a, double b){
        //Method sama param berbeda
        //Tipe Data double

        if(a>b){
            return a;
        } else{
            return b;
        }
    }

    static int maxNumber(int a, int b){

        //method sama parameter berbeda
        //tipe data double
        if (a>b){
            return a;
        } else{
            return b;
        }
    }
    public static void main(String[] args) {
        System.out.println(maxNumber(10, 20));
        System.out.println(maxNumber(4.5,7.5));

        //hasil dari nilai argumennya akan sesuai dengan tipe data parameternya
        //20 integer
        //7.5 double
    }
}
