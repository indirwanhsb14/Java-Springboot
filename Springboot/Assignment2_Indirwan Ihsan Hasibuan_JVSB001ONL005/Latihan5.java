import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Latihan5 {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        int i = 0;
        int jum = 0;
        double total = 0;
        
        int [] kode = new int[5];
        int [] qty = new int[5];
        int [] harga = new int[5];
        double [] subtotal = new double[5];
        double [] diskon = new double [5];
        String [] barang = new String[5];
         
        System.out.println("PROGRAM JAVA TENTANG PENJUALAN BARANG");
         
        System.out.print("Masukan Jumlah Beli : ");
        jum = input.nextInt();
        System.out.println(" ");
        
        for (i = 0; i < jum; i++){
            System.out.print("Masukan Kode Barang Ke-"+(i + 1)+" : ");
            kode[i] = input.nextInt();
            System.out.print("Masukan qty Ke-"+(i + 1)+" : ");
            qty[i] = input.nextInt();
            
            switch (kode[i]){
                case 1 : 
                    barang[i] = "Mouse Bluetooth 5.0  ";
                    harga[i] = 149999;
                    diskon[i] = 0.1;
                    break;
                case 2 : 
                    barang[i] = "Headphone Eksternal  ";
                    harga[i] = 246000;
                    diskon[i] = 0.05;
                    break;
                case 3 : 
                    barang[i] = "Power Bank 10.000 mAh";
                    harga[i] = 136000;
                    diskon[i] = 0;
                    break;
                case 4 : 
                    barang[i] = "Tripod Kamera        ";
                    harga[i] = 267999;
                    diskon[i] = 0.2;
                    break;
                case 5 : 
                    barang[i] = "Smart Watch Xiomi    ";
                    harga[i] = 899000;
                    diskon[i] = 0.1;
                    break;
                default : 
                System.out.println("Kode Barang Tidak Tersedia");
            }
        }
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
          
          System.out.println(" ");
          System.out.println("No   Nama Barang             Harga            QTY  Diskon   Sub Total");  
          
          for (i = 0; i<jum; i++){ 
             subtotal[i]=((qty[i]*harga[i])-(qty[i]*harga[i]*diskon[i]));
             total = total + subtotal[i];
              System.out.println(i+1+"    "+barang[i]+"   "+kursIndonesia.format(harga[i])+"    "+qty[i]+"     "+(int)(diskon[i]*100)+"%"+"     "+kursIndonesia.format(subtotal[i])); 
          }
          System.out.println(" ");
          System.out.println("Total Bayar : "+kursIndonesia.format(total));
    }
}