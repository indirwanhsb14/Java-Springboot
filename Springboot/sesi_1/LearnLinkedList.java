import java.util.*;

public class LearnLinkedList {
    public static void main(String[] args) {
        List <String> barang = new java.util.LinkedList<String>();
        barang.add("komputer");
        barang.add("laptop");
        barang.add("radio");
        System.out.println(barang);

        if(barang.isEmpty()){
            System.out.println("data kosong");
        }
        else {
            System.out.println("data penuh");
        }

        if(barang.contains("komputer")){
            System.out.println("data ditemukan");
        }else{
            System.out.println("data tidak ditemukan");
        }
    }
}
