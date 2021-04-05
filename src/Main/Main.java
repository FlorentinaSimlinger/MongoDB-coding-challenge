package Main;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            convertToJsonObj(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: converts input string to json object
    private static void convertToJsonObj(String jsonString) {
        JsonObject obj = JsonParser.parseString(jsonString).getAsJsonObject();
        System.out.println(obj);

    }


}
