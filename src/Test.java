import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        // [[1,2,3],[4,5,6],7,8,[9]]
        // {"A":"string","2":{"None":[1,[2,3],4]}}
        // {"A":"string","2":{"None":[1,[2,3],4],"Test":"Hi,siri","date":[2023,6,8]}}
        Scanner scan = new Scanner(System.in);
        System.out.println("Data that need to be processed (direct copypaste)");
        String S = scan.nextLine();
        scan.close();
        String[] L = S.split(":");
        for (String i : L) {
            i = i.replace("{", "").replace("}", "");
            // if (i.endsWith("]") || i.startsWith("[")) {
            System.out.println(i);
            // }
        }

    }

}
