
public class Segitiga extends BangunDatar {
    float alas;
    float tinggi;
    float sisi;

    float luas(){
        float luas= (alas*tinggi) / 2;
        System.out.println("Luas Segitiga           : "+ luas);
        return luas;
    }
    float keliling(){
        float keliling= 3 * sisi;
        System.out.println("Keliling Segitiga       : "+keliling);
        System.out.println(" ");
        return keliling;
    }
}
