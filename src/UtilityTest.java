import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UtilityTest {

    public static void main(String[] args) {
        Set<String> stopWords = new HashSet<>(
                Arrays.asList("the", "is", "in", "at", "of", "and", "a", "to", "it", "or", "was", "so"));
        Set<String> positiveWords = new HashSet<>(Arrays.asList("good", "great", "happy", "love", "like"));
        Set<String> negativeWords = new HashSet<>(Arrays.asList("bad", "terrible", "horrible", "sad", "hate"));

        String[] tokens = NLPUtility.splitTextIntoTokens("WOW!?!    That .?#       is  REALLY(reaLLy)  amazing!    ");
        System.out.println(Arrays.toString(tokens));

        String[] words = { "i", "love", "a", "good", "BOOK", "and", "LOVE", "sad", "BooK", "book" };
        System.out.println(NLPUtility.countFilteredWords(words, stopWords)); // {book=3, good=1, i=1, love=2, sad=1}

        Map<String, Integer> wordMap = new TreeMap<>();
        wordMap.put("book", 3);
        wordMap.put("good", 1);
        wordMap.put("i", 1);
        wordMap.put("love", 2);
        wordMap.put("sad", 1);

        System.out.println(wordMap); // {book=3, good=1, i=1, love=2, sad=1}

        System.out.println(NLPUtility.sortByValueDescending(wordMap)); // {book=3, love=2, good=1, i=1, sad=1}

        Map<String, Integer> wordMap2 = new LinkedHashMap<>();
        wordMap2.put("book", 3);
        wordMap2.put("love", 2); // positive
        wordMap2.put("good", 1); // positive
        wordMap2.put("i", 1);
        wordMap2.put("sad", 1); // negative
        System.out.println(wordMap2); // {book=3, love=2, good=1, i=1, sad=1}

        System.out.println(NLPUtility.getSentiment(wordMap2, positiveWords, negativeWords));// Positive: 3, Negative: 1

        Map<String, Integer> wordMap3 = new LinkedHashMap<>();
        wordMap3.put("good", 1);
        wordMap3.put("i", 1);
        wordMap3.put("love", 3);
        wordMap3.put("book", 3);
        wordMap3.put("sad", 1);
        System.out.println(wordMap3); // {good=1, i=1, love=3, book=3, sad=1}

        System.out.println(NLPUtility.getWordsWithMaxFrequency(wordMap3)); // {words=[book, love], frequency=3}
    }
}
