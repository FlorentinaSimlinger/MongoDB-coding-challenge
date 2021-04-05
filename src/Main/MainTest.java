package Main;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.builder.EqualsBuilder;


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
        JSONObject flattenedSimple = new JSONObject();
        flattenedSimple.put("a", 1);

        assertTrue(EqualsBuilder.reflectionEquals(Main.flattenJsonObj(simple), flattenedSimple));
    }

    @Test
    void testFlattenComplexJsonObject() {
        JSONObject complex = new JSONObject(complexString);
        JSONObject flattenedComplex = new JSONObject();
        flattenedComplex.put("a", 1);
        flattenedComplex.put("b", true);
        flattenedComplex.put("c.d", 3);
        flattenedComplex.put("c.e", "test");

        assertTrue(EqualsBuilder.reflectionEquals(Main.flattenJsonObj(complex), flattenedComplex));
    }

}