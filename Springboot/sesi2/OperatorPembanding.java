public class OperatorPembanding {
    
    public static void main(String[] args) {
        int nilaiA = 12;
        int nilaiB = 4;
        boolean hasil;

        //Apakah A lebih besar dari B?
        hasil = nilaiA > nilaiB;
        System.out.println(hasil);

        //Apakah A lebih kecil dari B?
        hasil = nilaiA < nilaiB;
        System.out.println(hasil);

        //Apakah A lebih besar sama dengan B?
        hasil = nilaiA >= nilaiB;
        System.out.println(hasil);

        //Apakah A lebih kecil sama dengan B?
        hasil = nilaiA <= nilaiB;
        System.out.println(hasil);

        //Apakah nilai A sama dengan B?
        hasil = nilaiA == nilaiB;
        System.out.println(hasil);

        //Apakah nilai A tidak sama dengan B?
        hasil = nilaiA != nilaiB;
        System.out.println(hasil);
    }
}
