package Main;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private String simpleString = "{ 'a' : 1}";
    private String complexString = "{\n" +
            "    \"a\": 1,\n" +
            "    \"b\": true,\n" +
            "    \"c\": {\n" +
            "        \"d\": 3,\n" +
            "        \"e\": \"test\"\n" +
            "    }\n" +
            "}";


    @Test
    void testConvertToSimpleJsonObject() {
        JSONObject simple = new JSONObject(simpleString);

        assertEquals(Main.convertToJsonObj(simpleString), simple);
    }

    @Test
    void testConvertToComplexJsonObject() {
        JSONObject complex = new JSONObject(complexString);/*
        complex.addProperty("a", 1);
        complex.addProperty("b", true);
        JSONObject innerOfComplex = new JSONObject();
        innerOfComplex.addProperty("d", 3);
        innerOfComplex.addProperty("e", "test");
        complex.add("c", innerOfComplex);*/

        assertEquals(Main.convertToJsonObj(complexString), complex);
    }

    @Test
    void testFlattenSimpleJsonObject() {
        JSONObject simple = new JSONObject(simpleString);

        JSONObject flattenedSimple = new JSONObject(simpleString);

        assertEquals(Main.flattenJsonObj(simple), flattenedSimple);
    }

    @Test
    void testFlattenComplexJsonObject() {
       /* JSONObject complex = new JSONObject();
        complex.addProperty("a", 1);
        complex.addProperty("b", true);
        JsonObject innerOfComplex = new JsonObject();
        innerOfComplex.addProperty("d", 3);
        innerOfComplex.addProperty("e", "test");
        complex.add("c", innerOfComplex);

        JSONObject flattenedComplex = new JSONObject();
        flattenedComplex.addProperty("a", 1);
        flattenedComplex.addProperty("b", true);
        flattenedComplex.addProperty("c.d", 3);
        flattenedComplex.addProperty("c.e", "test");
*/
        //assertEquals(Main.flattenJsonObj(complex), flattenedComplex);
    }

}