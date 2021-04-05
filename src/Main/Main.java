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
            System.out.println("reading done");
            String jsonString = sb.toString();
            System.out.println(jsonString);
            JSONObject inputObj = convertToJsonObj(jsonString);
            JSONObject flattenedObj = flattenJsonObj(inputObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // REQUIRES: a valid json string
    // EFFECTS: returns a json object from the json string
    public static JSONObject convertToJsonObj(String jsonString) {
        return new JSONObject(jsonString);
    }

    public static JSONObject flattenJsonObj(JSONObject obj) {
        JSONObject result = new JSONObject();

        flattenJsonObjHelper(obj, result, "");

        return result;

    }

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
