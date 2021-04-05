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
                    System.out.println(inputStr);
                }
            }
            String jsonString = sb.toString();
            JSONObject inputObj = new JSONObject(jsonString);
            JSONObject flattenedObj = flattenJsonObj(inputObj);
            System.out.println(flattenedObj);
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
    public static JSONObject flattenJsonObjHelper(JSONObject currObj, JSONObject newObj, String prevKeyName) {
        Iterator<?> keys = currObj.keys();
        while (keys.hasNext()) {
            // value is a json object
            String key = (String) keys.next();
            if (currObj.get(key) instanceof JSONObject) {
                // first call
                if (prevKeyName.equals("")) {
                    return flattenJsonObjHelper((JSONObject) currObj.get(key), newObj, key);
                } else {
                    return flattenJsonObjHelper((JSONObject) currObj.get(key), newObj, prevKeyName + '.' + key);
                }
            // value is not a json object
            } else {
                // first call
                if (prevKeyName.equals("")) {
                    newObj.put(key, currObj.get(key));
                } else {
                    newObj.put(prevKeyName + "." + key, currObj.get(key));
                }
            }
        }
        return null;
    }
}
