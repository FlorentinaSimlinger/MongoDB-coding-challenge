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

    private String complexFlattenedString = "{'a':1, 'b':true, 'c.d':3, 'c.e':'test'}";

    @Test
    void testConvertToSimpleJsonObject() {
        JSONObject simple = new JSONObject(simpleString);

        assertEquals(simple, Main.convertToJsonObj(simpleString));
    }

    @Test
    void testConvertToComplexJsonObject() {
        JSONObject complex = new JSONObject(complexString);

        assertEquals(complex, Main.convertToJsonObj(complexString));
    }

    @Test
    void testFlattenSimpleJsonObject() {
        JSONObject simple = new JSONObject(simpleString);

        JSONObject flattenedSimple = new JSONObject(simpleString);

        assertEquals(flattenedSimple, Main.flattenJsonObj(simple));
    }

    @Test
    void testFlattenComplexJsonObject() {

        JSONObject complex = new JSONObject(complexString);
        JSONObject flattenedComplex = new JSONObject(complexFlattenedString);

        assertEquals(flattenedComplex, Main.flattenJsonObj(complex));
    }

}