import java.util.*;

public class NLPUtilitySolution {

    /**
     * A set of stop words to ignore during word frequency analysis.
     */
    public static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "is", "in", "at", "of", "and", "a", "to", "it", "or", "was", "so"));

    // JDK 11+
    // public static final Set<String> STOP_WORDS = Set.of( "the", "is", "in", "at",
    // "of", "and", "a", "to", "it", "or", "was", "so");

    /**
     * A set of words deemed positive.
     */
    public static final Set<String> POSITIVE_WORDS = new HashSet<>(
            Arrays.asList("good", "great", "happy", "love", "like"));

    /**
     * A set of words deemed negative.
     */
    public static final Set<String> NEGATIVE_WORDS = new HashSet<>(
            Arrays.asList("bad", "terrible", "horrible", "sad", "hate"));

    /**
     * Splits the given text into word tokens using one or more whitespace
     * or punctuation characters as delimiters.
     *
     * @param text the input string to be tokenized
     * @return an array of word tokens, excluding punctuation and whitespace
     */
    public static String[] getWordTokens(String text) {
        return text.split("[\\s\\p{Punct}]+");
    }

    /**
     * Counts the frequency of non-stop words in the given array of words, ignoring case.
     * Uses a {@code TreeMap} to store and sort the words alphabetically.
     *
     * @param words An array of tokenized words.
     * @return A {@code TreeMap} containing each non-stop word and its frequency.
     */
    public static TreeMap<String, Integer> getNonStopWordFrequencies(String[] words) {
        TreeMap<String, Integer> wordFrequency = new TreeMap<>();
        for (String rawWord : words) {
            String word = rawWord.toLowerCase();
            if (!STOP_WORDS.contains(word)) {
                if (wordFrequency.containsKey(word)) {
                    wordFrequency.put(word, wordFrequency.get(word) + 1);
                } else {
                    wordFrequency.put(word, 1);
                }
            }
        }
        return wordFrequency;
    }

    /**
     * Sorts a map of word frequencies by their values in descending order.
     * The entries are returned in a LinkedHashMap to preserve the
     * order of the entries after sorting.
     *
     * @param wordMap A map containing words as keys and their corresponding
     *                frequencies as values.
     * @return A LinkedHashMap with the same entries as the original map,
     *         but sorted by the frequency (value) of the words in descending order.
     */
    public static LinkedHashMap<String, Integer> getMapSortedByValueDesc(Map<String, Integer> wordMap) {
        // Convert map entries to a list for sorting
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordMap.entrySet());

        // Sort the list in descending order based on frequency (value)
        entryList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // Use LinkedHashMap to maintain the order of sorted entries
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Return the sorted map
        return sortedMap;
    }

    /**
     * Performs sentiment analysis by scanning the word-frequency map.
     * Adds up the total frequency of all words found in the predefined
     * positive and negative word sets.
     *
     * @param wordMap A map of words and their frequencies.
     * @return A summary string in the format: "Positive: X, Negative: Y"
     *         where X and Y are the total counts of positive and negative words.
     */
    public static String getSentimentFromFrequencies(Map<String, Integer> wordMap) {
        // Initialize counters for positive and negative words
        int positive = 0;
        int negative = 0;

        // Iterate through each word-frequency entry in the word map
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String word = entry.getKey(); // Current word
            int count = entry.getValue(); // Frequency of the word

            // Check if the word is in the list of positive words
            if (POSITIVE_WORDS.contains(word)) {
                positive += count; // Increment the positive counter by the word's frequency
            }
            // Check if the word is in the list of negative words
            else if (NEGATIVE_WORDS.contains(word)) {
                negative += count; // Increment the negative counter by the word's frequency
            }
        }

        // Return the sentiment analysis result as a formatted string
        return String.format("Positive: %d, Negative: %d", positive, negative);
    }

    /**
     * Returns a list of the word(s) with the highest frequency from the given map.
     * If multiple words share the highest frequency, all are included in the
     * result.
     * The returned list is sorted alphabetically.
     *
     * @param wordMap a map containing words and their corresponding frequencies
     * @return an alphabetically sorted list of the most frequent word(s)
     */
    public static List<String> getMostFrequentWords(Map<String, Integer> wordMap) {
        // Find the maximum frequency value in the word map
        int maxFreq = Collections.max(wordMap.values());

        // Create a list to store the words with the highest frequency
        List<String> result = new ArrayList<>();

        // Iterate through the entries of the word map
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            // If the frequency of the current word matches the maximum frequency, add it to
            // the result list
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        // Sort the result list alphabetically
        Collections.sort(result);

        // Return the sorted list of most frequent word(s)
        return result;
    }

}
