
public class PersegiPanjang extends BangunDatar {
    float panjang;
    float lebar;

    float luas(){
        float luas= panjang * lebar;
        System.out.println("Luas Persegi Panjang    : "  + luas);
        return luas;
    }
    float keliling(){
        float keliling= 2* panjang+ 2*lebar;
        System.out.println("Keliling Persegi Panjang: "+ keliling);
        System.out.println(" ");
        return keliling;
    }
}
