package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {
            InputStreamReader isReader = new InputStreamReader(System.in);
            BufferedReader bufReader = new BufferedReader(isReader);
            String inputString = "";
            while (inputString != null) {
                inputString = bufReader.readLine();
                System.out.println(inputString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
