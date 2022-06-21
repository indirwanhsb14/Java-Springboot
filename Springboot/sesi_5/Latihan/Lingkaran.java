
public class Lingkaran extends BangunDatar {
    float r;

    float luas(){
        float luas= (float)(Math.PI * r * r);
        System.out.println("luas Lingkaran          : " + luas);
        return luas;
    }
    float keliling(){
        float keliling =(float)(2 * Math.PI * r);
        System.out.println("Keliling Lingkaran      : "+ keliling);
        System.out.println(" ");
        return keliling;
    }
}
