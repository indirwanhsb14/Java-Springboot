public class ArrayMulti {
    public static void main(String[] args) {
        String[][] framework = {{"Java","Kotlin"},{"React,","Reactnative"},{"Php","Laravel"}};

        for(int x=0; x<framework.length; x++){
            System.out.println("Bahasa: " + framework[x][0]);
            System.out.println("framework: " + framework[x][1]);
            System.out.println("===========================");
        }
    }
}
