import java.util.*;

public class NLPUtility {

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
        // TODO
        return null;
    }

    /**
     * Counts the frequency of non-stop words in the given array of words, ignoring case.
     * Uses a {@code TreeMap} to store and sort the words alphabetically.
     *
     * @param words An array of tokenized words.
     * @return A {@code TreeMap} containing each non-stop word and its frequency.
     */
    public static TreeMap<String, Integer> getNonStopWordFrequencies(String[] words) {
        // TODO
        return null;
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
        // TODO
        return null;
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
        // TODO
        return null;
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
        // TODO
        return null;
    }

}
