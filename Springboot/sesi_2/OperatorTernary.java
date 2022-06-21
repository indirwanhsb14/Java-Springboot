public class OperatorTernary {
    public static void main(String[] args) {
        mainTernary();
    }

    private static void mainTernary() {
        boolean suka = true;
        System.out.println(cekJawaban(suka));
    }

    private static String cekJawaban(boolean suka) {
        String jawaban = suka ? "iya" : "tidak";
        return jawaban;
    }
}
