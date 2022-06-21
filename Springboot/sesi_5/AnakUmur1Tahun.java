public class AnakUmur1Tahun extends Induk implements AktivitasPagi {
    
    @Override
    public void namaAnak(){
        System.out.println("Nama anaknya adalah : " + namaAnak);
    }

    
    public void aktivitasAnak(){
        System.out.println("Aktivitas Pagi anak sedang " + citaAnak);
    }
   
}

