package io.github.schntgaispock.gastronomicon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import io.github.schntgaispock.gastronomicon.util.NumberUtil;

public class UtilTests {
    public static void main(String[] args) {
        // TEST #1: GastroUtil.asRomanNumeral()
        final Map<Integer, String> test1 = new LinkedHashMap<>();
        test1.put(0, "0");
        test1.put(1, "I");
        test1.put(2, "II");
        test1.put(3, "III");
        test1.put(4, "IV");
        test1.put(5, "V");
        test1.put(6, "VI");
        test1.put(7, "VII");
        test1.put(8, "VIII");
        test1.put(9, "IX");
        test1.put(10, "X");
        test1.put(15, "XV");
        test1.put(99, "XCIX");
        test1.put(100, "C");
        test1.put(1000, "M");
        test1.put(4000, "4000");

        test(test1, NumberUtil::asRomanNumeral, "#1");
    }

    public static <R, T> void test(Map<R, T> tests, Function<R, T> toTest, String id) {
        System.out.println("[TESTING " + id + "]");
        int i = 0;
        for (Map.Entry<R, T> test : tests.entrySet()) {
            i++;
            T result = null;
            String resultString = "";

            try {
                result = toTest.apply(test.getKey());
                resultString = result.toString();
            } catch (Exception e) {
                resultString = e.getMessage();
            }

            System.out.println("[CASE " + i + " " + (test.getValue().equals(result) ? "PASSED" : "FAILED") + "]: INPUT: " + test.getKey().toString() + ", EXPECTED: " + test.getValue().toString() + ", GOT: " + resultString);
        }
    }
}
