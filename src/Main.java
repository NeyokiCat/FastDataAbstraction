import java.util.*;

public class Main {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Data that need to be processed (direct copypaste)");
        String S = scan.nextLine();
        System.out.println("Explain in (indented, jsonNode)");
        String F = scan.nextLine();
        Abstr n1 = new Abstr(S, F);
        scan.close();
        System.out.println(n1);
        if (F.toLowerCase().equals("indented")) {
            System.out.println(n1.indented());
        } else if (F.toLowerCase().equals("jsonnode")) {
            System.out.println(n1.jsonNode());
        } else {
            System.out.println("Invalide input");
        }
    }
}
