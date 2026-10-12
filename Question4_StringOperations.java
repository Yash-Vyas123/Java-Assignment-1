
import java.util.Arrays;

public class Question4_StringOperations {

    public static void main(String[] args) {

        String s = "Hello Java";
        String s2 = "Hello Java";

        // 1. length()
        System.out.println("Length: " + s.length());

        // 2. isEmpty()
        System.out.println("Is empty: " + s.isEmpty());

        // 3. charAt()
        System.out.println("Character at index 1: " + s.charAt(1));

        // 4. toString()
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("toString: " + sb.toString());

        // 5. equals()
        System.out.println("Equals: " + s.equals(s2));

        // 6. compareTo()
        System.out.println("CompareTo: " + s.compareTo("Hello"));

        // 7. contains()
        System.out.println("Contains Java: " + s.contains("Java"));

        // 8. indexOf()
        System.out.println("Index of a: " + s.indexOf('a'));

        // 9. lastIndexOf()
        System.out.println("Last index of a: " + s.lastIndexOf('a'));

        // 10. startsWith()
        System.out.println("Starts with Hello: " + s.startsWith("Hello"));

        // 11. endsWith()
        System.out.println("Ends with Java: " + s.endsWith("Java"));

        // 12. matches()
        System.out.println("Matches letters and space: "
                           + s.matches("[A-Za-z ]+"));

        // 13. substring()
        System.out.println("Substring: " + s.substring(6));

        // 14. toLowerCase()
        System.out.println("Lowercase: " + s.toLowerCase());

        // 15. trim()
        String spaced = "   Hello Java   ";
        System.out.println("Trim: '" + spaced.trim() + "'");

        // 16. replace()
        System.out.println("Replace: " + s.replace("Java", "World"));

        // 17. split()
        String fruits = "Apple,Banana,Mango";
        String[] arr = fruits.split(",");
        System.out.println("Split: " + Arrays.toString(arr));

        // 18. join()
        System.out.println("Join: " + String.join("-", arr));

        // 19. valueOf()
        int number = 123;
        String numString = String.valueOf(number);
        System.out.println("ValueOf: " + numString);

        // StringBuffer example
        StringBuffer buffer = new StringBuffer("Hello");
        buffer.append(" World");
        System.out.println("StringBuffer: " + buffer);

        // StringBuilder example
        StringBuilder builder = new StringBuilder("Java");
        builder.append(" Programming");
        System.out.println("StringBuilder: " + builder);
    }
}
