import java.util.*;

public class NLPUtilitySolution {

    /**
     * Splits the given text into word tokens using one or more whitespace
     * or punctuation characters as delimiters.
     *
     * @param text the input string to be tokenized
     * @return an array of word tokens, excluding punctuation and whitespace
     */
    public static String[] splitTextIntoTokens(String text) {
        return text.split("[\\s\\p{Punct}]+");
    }

    /**
     * Counts the frequency of words in the given array, excluding those present in
     * the specified set of stop words.
     * The comparison is case-insensitive, and results are stored in a
     * {@link TreeMap} sorted alphabetically by word.
     *
     * @param words     An array of tokenized words to analyze.
     * @param stopWords A set of words to exclude from the frequency count (e.g.,
     *                  common stop words like "the", "and").
     * @return A {@link TreeMap} mapping each non-stop word to its frequency, sorted
     *         alphabetically.
     */
    public static TreeMap<String, Integer> countFilteredWords(String[] words, Set<String> stopWords) {
        TreeMap<String, Integer> wordFrequency = new TreeMap<>();
        for (String rawWord : words) {
            String word = rawWord.toLowerCase();
            if (!stopWords.contains(word)) {
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
     * Sorts the entries of a map by their values in descending order.
     * The result is returned as a {@link LinkedHashMap} to preserve the order of
     * sorted entries.
     *
     * @param map A map containing keys and integer values to be sorted by value.
     * @return A {@link LinkedHashMap} containing the same entries as the input map,
     *         sorted in descending order by value.
     */
    public static LinkedHashMap<String, Integer> sortByValueDescending(Map<String, Integer> map) {
        // Convert map entries to a list for sorting
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list in descending order of value
        entryList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // Create LinkedHashMap to maintain the order of sorted entries
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
    public static String getSentiment(Map<String, Integer> wordMap, Set<String> positiveWords,
            Set<String> negativeWords) {
        // Initialize counters for positive and negative words
        int positive = 0;
        int negative = 0;

        // Iterate through each word-frequency entry in the word map
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String word = entry.getKey(); // Current word
            int count = entry.getValue(); // Frequency of the word

            // Check if the word is in the list of positive words
            if (positiveWords.contains(word)) {
                positive += count; // Increment the positive counter by the word's frequency
            }
            // Check if the word is in the list of negative words
            else if (negativeWords.contains(word)) {
                negative += count; // Increment the negative counter by the word's frequency
            }
        }

        // Return the sentiment analysis result as a formatted string
        return String.format("Positive: %d, Negative: %d", positive, negative);
    }

    /**
     * Finds the words with the highest frequency in the given map and returns a map
     * containing a sorted word list along with the maximum frequency value.
     *
     * @param wordMap A map of words and their corresponding frequencies.
     * @return A map containing:
     *         - "words": A list of words with the highest frequency, sorted
     *         alphabetically.
     *         - "frequency": The highest frequency value.
     */
    public static Map<String, Object> getWordsWithMaxFrequency(Map<String, Integer> wordMap) {
        // Find the maximum frequency value in the word map
        int maxFreq = Collections.max(wordMap.values());

        // Create a list to store the words with the highest frequency
        List<String> wordList = new ArrayList<>();

        // Iterate through the entries of the word map
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            // If the frequency of the current word matches the maximum frequency, add it to
            // the result list
            if (entry.getValue() == maxFreq) {
                wordList.add(entry.getKey());
            }
        }

        // Sort the result list alphabetically
        Collections.sort(wordList);

        // Create a map to store both the words and the maximum frequency value
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("words", wordList);
        resultMap.put("frequency", maxFreq);

        // Return the map containing both the word list and the frequency
        return resultMap;
    }

}
