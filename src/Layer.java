import java.util.*;

public class Layer {
    String targetH;
    String targetT;
    String Seg;
    String Type;
    int init;
    int layer;
    // String Skip;

    public Layer(String T) {
        Type = T;
    }

    public Layer(String H, String T, String S /* ,String Sk */) {
        targetH = H;
        targetT = T;
        Seg = S;
        // Skip = Sk;
    }

    public Layer(String H, String T, String S, int I, int L) {
        targetH = H;
        targetT = T;
        Seg = S;
        init = I;
        layer = L;
    }

    public String indexing(int times) {
        String out = "";
        for (int i = 0; i < times; i++) {
            out = "  " + out;
        }
        return out;
    }

    public String toString(String in) {
        return LayerCount(in).toString();
    }

    public ArrayList<Integer> LayerCount(String in) {
        ArrayList<Integer> A = new ArrayList<>();
        int layr = layer - 1;
        for (int i = init; i < in.length(); i++) {
            String sub = in.substring(i, i + 1);
            // System.out.println(sub);
            if (sub.equals(targetH)) {
                layr++;
            } else if (sub.equals(targetT)) {
                layr--;
            } else if (!sub.equals(Seg)) {
                A.add(layr);
            }

        }
        return A;
    }

    public String LayerOut(String in) {
        String A = "";
        int layr = layer;
        for (int i = init; i < in.length(); i++) {
            String sub = in.substring(i, i + 1);
            if (sub.equals(targetH)) {
                String e = "\33[3" + (layr % 7 + 1) + "m" + sub + "\33[0m";
                A += indexing(layr) + e + "\n";
                layr++;
            } else if (sub.equals(targetT)) {
                String e = "\33[3" + (layr % 7) + "m" + sub + "\33[0m";
                A += "\n" + indexing(layr - 1) + e;
                layr--;
            } else if (!sub.equals(Seg)) {
                String e = "\33[3" + (layr % 7) + "m" + sub + "\33[0m";
                A += indexing(layr) + e;
            } else {
                A += Seg + "\n";
            }
        }
        return A;
    }

    public String arrayLayer(String in) {
        String A = "";
        int layr = layer;
        for (int i = init; i < in.length(); i++) {
            String sub = in.substring(i, i + 1);
            if (sub.equals("[")) {
                String e = "\33[3" + (layr % 7 + 1) + "m" + sub + "\33[0m";
                A += indexing(layr) + e + "\n";
                layr++;
            } else if (sub.equals("]")) {
                String e = "\33[3" + (layr % 7) + "m" + sub + "\33[0m";
                A += "\n" + indexing(layr - 1) + e;
                layr--;
            } else if (!sub.equals(",")) {
                String e = "\33[3" + (layr % 7) + "m" + sub + "\33[0m";
                A += indexing(layr) + e;
            } else {
                A += ",\n";
            }
        }
        return A;
    }

    public String jsonLayer(String in) {
        String A = "";
        int layr = layer;
        for (int i = 0; i < in.length(); i++) {
            String sub = in.substring(i, i + 1);
            if (sub.equals("\"")) {
                sub = in.substring(i, in.indexOf("\"", i));
                String e = "\33[3" + (layr % 7) + "m" + sub + "\33[0m";
                A += e + "\"";
                i += sub.length();
            } else {
                if (sub.equals("{")) {
                    String e = "\33[3" + (layr % 7 + 1) + "m" + sub + "\33[0m";
                    A += indexing(layr) + e + "\n";
                    layr++;
                } else if (sub.equals("}")) {
                    String e = "\33[3" + (layr % 7) + "m" + sub + "\33[0m";
                    A += "\n" + indexing(layr - 1) + e;
                    layr--;
                } else if (sub.equals(":")) {
                    A += ": ";
                } else if (sub.equals(",")) {
                    A += ",\n";
                } else {
                    String e = "\33[3" + (layr % 7) + "m" + sub + "\33[0m";
                    A += e;
                }
            }
        }
        return A;

    }
}
