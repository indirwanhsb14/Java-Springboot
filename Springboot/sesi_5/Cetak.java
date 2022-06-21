abstract class Manusia {
    //Deklarasi class dan method tipe abstract
    protected abstract void nyanyiLagu();
}

class Cowok extends Manusia{
    //Menggunakan method dari class abstract manusia
    @Override
    protected void nyanyiLagu(){
        System.out.println("da du du di dam");
        //statement dari perilaku yang menampilkan output pesan text yang berbeda dari class manusia
    }
}

class Cewek extends Manusia{
    //Menggunakan method dari class abstract manusia
    @Override
    protected void nyanyiLagu(){
        System.out.println("du ri dam dam");
        //statement dari perilaku yang menampilkan output pesan text yang berbeda dari class manusia
    }
}

public class Cetak{

    public static void main(String[] args) {
        //Buat Object refrensi class manusia, dengan cons cowok
        Manusia cowok = new Cowok();

        //Menampilkan output pada method yang ada di class cowok
        cowok.nyanyiLagu();

        //Buat Object refrensi class manusia, dengan cons cewek
        Manusia cewek = new Cewek();

        //Menampikan output pada method yang ada di class cewek
        cewek.nyanyiLagu();
    }
}
