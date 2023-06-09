
// import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Abstr {
    public String str;
    public String Oformate;
    public String Tformate;

    public Abstr(String S, String F) {
        str = S;
        Tformate = F;
        detectForm();
    }

    public String indexing(int times) {
        String out = "";
        for (int i = 0; i < times; i++) {
            out = "  " + out;
        }
        return out;
    }

    public void detectForm() {
        Oformate = "String";
        if (str.contains("[")) {
            Oformate = "Array";
        }
        if (str.contains("{")) {
            Oformate = "Json";
        }
    }

    public String indented() {
        String out = "";
        if (Oformate == "Array") {
            String input = str;
            Layer a = new Layer("array");
            // System.out.println(i.toString(input));
            out = a.arrayLayer(input);
        }
        if (Oformate == "Json") {
            String input = str;
            Layer j = new Layer("json");
            out = j.jsonLayer(input);
        }
        return out;
    }

    public String jsonNode() {
        String json = str;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String formattedJson = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(objectMapper.readValue(json, JsonNode.class));
            /// System.out.println(formattedJson);
            return formattedJson;
        } catch (Exception e) {
            e.printStackTrace();
            return "Unexpected Error occurs";
        }

    }

    public String toString() {
        return "Intended to explain " + Oformate + " in " + Tformate;
    }
}
