import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a paragraph of text:");
        String input = scanner.nextLine();

        // Tokenize the input string
        String[] words = NLPUtility.getWordTokens(input);
        System.out.println("\nTokenized:");
        System.out.println(Arrays.toString(words));

        // Get map of non-stop words sorted by key
        Map<String, Integer> mapSortedByKey = NLPUtility.getNonStopWordFrequencies(words);

        // If the map is empty, inform the user and stop the analysis.
        if (mapSortedByKey == null || mapSortedByKey.isEmpty()) {
            System.out.println("\nNo valid words found.");
        } else {
            System.out.println("\nWord map sorted by key ascending:");
            mapSortedByKey.forEach((k, v) -> System.out.println(k + ":" + v));

            System.out.println("\nWord map sorted by value descending:");
            Map<String, Integer> mapSortedByValue = NLPUtility.getMapSortedByValueDesc(mapSortedByKey);
            mapSortedByValue.forEach((k, v) -> System.out.println(k + ":" + v));

            // Perform sentiment analysis on word map
            String sentiment = NLPUtility.getSentimentFromFrequencies(mapSortedByKey);
            System.out.println("\nSentiment: " + sentiment);

            // Display most frequent word(s)
            List<String> mostFrequent = NLPUtility.getMostFrequentWords(mapSortedByKey);
            int max = mapSortedByKey.get(mostFrequent.get(0));
            System.out.println("\nMost frequent word(s): " + mostFrequent + " (used " + max + " times)");
        }
        scanner.close();
    }

}
