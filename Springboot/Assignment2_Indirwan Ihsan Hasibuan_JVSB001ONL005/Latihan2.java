import java.util.Scanner;
public class Latihan2 {
    
    public static void main(String[] args) {
        
        int i=0;
        Scanner scan = new Scanner(System.in);
        String[] pos = new String[6];
        
        for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 3; y++) {
				System.out.format("Siapa yang akan duduk di kelas (%d,%d): ",x,y);
				pos[i] = scan.nextLine();
				i++;
			}
		}
        System.out.println("===================================================");
        System.out.println("| "+pos[0] +"  |\t\t"+ "|"+pos[1] +"|\t\t"+"|"+pos[2]+"|");
        System.out.println("|"+pos[3]+"|\t\t"+ "|"+pos[4]+"|\t"+"|"+ pos[5]+"|");
        System.out.println("===================================================");
    }
}