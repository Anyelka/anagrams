import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text1;
        String text2;
        while(true) {
            System.out.println("\nPlease add the first text:");
            text1 = reader.readLine();
            System.out.println("\nPlease add the second text:");
            text2 = reader.readLine();

            // Part 1
            System.out.print("\n = Part 1 = \n");
            boolean areAnagrams = Service.getSolution1(text1, text2);
            System.out.printf(" The two texts: (%s,%s) are %sanagrams%n", text1, text2, areAnagrams ? "" : "NOT ");

            // Part 2
            System.out.print("\n = Part 2 = \n ");
            Map<String, List<String>> allTexts = Service.getSolution2(text1, text2);
            allTexts.forEach((key, value) -> System.out.printf("\n   - All anagrams for '%s' are: %s", key, value));
        }
    }


}