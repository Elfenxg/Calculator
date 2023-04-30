import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Converter {
    final static Map<Character, Integer> ROMAN_TO_ARABIC = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    final static Map<Integer, String> ARABIC_TO_ROMAN = new TreeMap<Integer, String>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    static int toArabic(String roman) {
        int result = 0;
        int prevValue = 0;

        for (char c : roman.toCharArray()) {
            int currentValue = ROMAN_TO_ARABIC.get(c);
            result += currentValue;

            if (currentValue > prevValue) {
                result -= 2 * prevValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    public static String toRoman(int arabic) {
        if (arabic <= 0) {
            throw new IllegalArgumentException("Roman numerals cannot represent zero or negative numbers.");
        }

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> entry : ARABIC_TO_ROMAN.entrySet()) {
            int value = entry.getKey();
            String numeral = entry.getValue();

            while (arabic >= value) {
                result.append(numeral);
                arabic -= value;
            }
        }

        return result.toString();
    }

    public static boolean isValid(String roman) {
        String pattern = "^[IVXLCDM]+$";
        return roman.matches(pattern);
    }

    /*
    public static boolean isValid(String roman) {
        String pattern = "^[IVXLCDM]+$";
        return roman.matches(pattern);
    }
    */
}
