package Main;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        try {
            InputStreamReader isReader = new InputStreamReader(System.in);
            BufferedReader bufReader = new BufferedReader(isReader);
            String inputStr = "";
            StringBuilder sb = new StringBuilder();
            while (inputStr != null) {
                inputStr = bufReader.readLine();
                if (inputStr != null) {
                    sb.append(inputStr);
                }
            }
            String jsonString = sb.toString();
            JSONObject inputObj = new JSONObject(jsonString);
            JSONObject flattenedObj = flattenJsonObj(inputObj);
            System.out.println(flattenedObj.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // EFFECTS: returns the flattened json object by calling the helper method
    public static JSONObject flattenJsonObj(JSONObject obj) {
        JSONObject result = new JSONObject();

        flattenJsonObjHelper(obj, result, "");

        return result;

    }

    // EFFECTS: returns the flattened json object
    public static void flattenJsonObjHelper(JSONObject currObj, JSONObject newObj, String prevKeyName) {
        Iterator<?> keys = currObj.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            if (currObj.get(key) instanceof JSONObject) {
                if (key == null || prevKeyName.equals("")) {
                    flattenJsonObjHelper((JSONObject) currObj.get(key), newObj, key);
                } else {
                    flattenJsonObjHelper((JSONObject) currObj.get(key), newObj, prevKeyName + '.' + key);
                }
            } else {
                if (key == null || prevKeyName.equals("")) {
                    newObj.put(key, currObj.get(key));
                } else {
                    newObj.put(prevKeyName + "." + key, currObj.get(key));
                }
            }
        }
    }
}
