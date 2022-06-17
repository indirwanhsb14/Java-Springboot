public class Makanan {
    public static void main(String[] args) {
        
        //Membuat instance atau objek dari class restoran
        Restoran data = new Restoran();

        //Membuat Data pada Variabel
        data.setMenu("Mie Ayam");
        data.setHarga(22000);
        data.setSpesial(true);

        //Memanggil method Get dari class restoran
        System.out.println("Menu Makanan    : " +data.getMenu());
        System.out.println("Harga Makanan   : Rp." +data.getHarga());
        System.out.println("Menu Spesial    : " +data.getSpesial());
        System.out.println(" ");
        System.out.println("Semoga Datang Kembali");
    }
}
