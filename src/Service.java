import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Service {
    private static final List<String> texts = new ArrayList<>();

    public static boolean getSolution1(String text1, String text2) {
        return areAnagrams(text1, text2);
    }

    public static Map<String, List<String>> getSolution2(String text1, String text2) {
        addTexts(text1, text2);
        return texts.stream().collect(Collectors.toMap(Function.identity(), Service::getAllAnagrams));
    }

    private static void addTexts(String text1, String text2) {
        if(!texts.contains(text1)) {
            texts.add(text1);
        }
        if(!texts.contains(text2)) {
            texts.add(text2);
        }
    }

    public static List<String> getAllAnagrams(String text) {
        return texts.stream()
                .filter(text2 -> !Objects.equals(text2, text) && areAnagrams(text, text2))
                .collect(Collectors.toList());
    }

    public static boolean areAnagrams(String text1, String text2) {
        char[] word1Chars = text1.replaceAll(" ", "").toLowerCase().toCharArray();
        char[] word2Chars = text2.replaceAll(" ", "").toLowerCase().toCharArray();
        Arrays.sort(word1Chars);
        Arrays.sort(word2Chars);
        return Arrays.equals(word1Chars, word2Chars);
    }
}
