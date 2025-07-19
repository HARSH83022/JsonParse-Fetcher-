import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class JSONParser {
    public static void parseJSON(String content) {
        try {
            JSONObject jsonObject = new JSONObject(content);
            System.out.println("Valid JSON Object:");
            System.out.println(jsonObject.toString(2));
        } catch (JSONException e1) {
            try {
                JSONArray jsonArray = new JSONArray(content);
                System.out.println("Valid JSON Array:");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    System.out.println(obj.toString(2));
                }
            } catch (JSONException e2) {
                System.out.println("Invalid JSON: " + e2.getMessage());
            }
        }
    }
}
