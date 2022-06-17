public class BreakAndContinue {
    public static void main(String[] args) {
        int i;
        for(i = 0; i < 4; i++){
            if(i >= 3){
                break;
            }
            System.out.println("Selamat Belajar!");
            if(i >= 2){
                continue;
            }
            System.out.println("Java");

        }
        System.out.println(i);
    }
}
