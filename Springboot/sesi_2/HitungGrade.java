import java.util.Scanner;

//Kondisi Jika: 
//Nilainya lebih dari 90 grade-nya A
//Nilainya lebih dari 80 grade-nya B+
//Nilainya lebih dari 70 grade-nya B
public class HitungGrade {
    
    public static void main(String[] args) {
        
        //Membuat variabel dan Scanner
        int nilai;
        String grade;
        Scanner scan = new Scanner(System.in);

        //Mengambil Input
        System.out.print("Inputkan nilai: ");
        nilai = scan.nextInt();

        //Hitung Grade
        if (nilai >= 90){
            grade = "A";
        } else if (nilai >= 80){
            grade = "B+";
        }else if (nilai >= 70){
            grade = "B";
        }else if (nilai >= 60){
            grade = "C+";
        }else if (nilai >= 50){
            grade = "C";
        }else if (nilai >= 40){
            grade = "D";
        }else{
            grade = "E";
        }

        //Cetak hasilnya
        System.out.println("Grade: " + grade);

        scan.close();
    }
}
