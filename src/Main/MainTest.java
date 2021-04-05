package Main;

import com.google.gson.JsonObject;
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
        JsonObject simple = new JsonObject();
        simple.addProperty("a", 1);

        assertEquals(Main.convertToJsonObj(simpleString), simple);
    }

    @Test
    void testConvertToComplexJsonObject() {
        JsonObject complex = new JsonObject();
        complex.addProperty("a", 1);
        complex.addProperty("b", true);
        JsonObject innerOfComplex = new JsonObject();
        innerOfComplex.addProperty("d", 3);
        innerOfComplex.addProperty("e", "test");
        complex.add("c", innerOfComplex);

        assertEquals(Main.convertToJsonObj(complexString), complex);
    }

    @Test
    void testFlattenSimpleJsonObject() {
        JsonObject simple = new JsonObject();
        simple.addProperty("a", 1);

        JsonObject flattenedSimple = new JsonObject();
        flattenedSimple.addProperty("a", 1);

        assertEquals(Main.flattenJsonObj(simple), flattenedSimple);
    }

    @Test
    void testFlattenComplexJsonObject() {
        JsonObject complex = new JsonObject();
        complex.addProperty("a", 1);
        complex.addProperty("b", true);
        JsonObject innerOfComplex = new JsonObject();
        innerOfComplex.addProperty("d", 3);
        innerOfComplex.addProperty("e", "test");
        complex.add("c", innerOfComplex);

        JsonObject flattenedComplex = new JsonObject();
        flattenedComplex.addProperty("a", 1);
        flattenedComplex.addProperty("b", true);
        flattenedComplex.addProperty("c.d", 3);
        flattenedComplex.addProperty("c.e", "test");

        assertEquals(Main.flattenJsonObj(complex), flattenedComplex);
    }

}