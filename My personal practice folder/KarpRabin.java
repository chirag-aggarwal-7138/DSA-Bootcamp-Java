/**
 * The Karp-Rabin algorithm is a string searching algorithm that finds the occurrence of a pattern in a text.
 */

public class KarpRabin {

    private final int PRIME = 101;

    /**
     * Calculates the hash value of a given string using the Karp-Rabin algorithm.
     * @param str The string to calculate the hash value for.
     * @return The hash value of the given string.
     */
    private long calculateHash(String str) {
        long hash = 0;

        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }

        return hash;
    }

    /**
     * Updates the hash value of a string after a character is replaced.
     * @param prevHash The previous hash value of the string.
     * @param oldChar The character being replaced.
     * @param newChar The new character.
     * @param patternLength The length of the pattern being searched for.
     * @return The updated hash value of the string.
     */
    private long updateHash(long prevHash, char oldChar, char newChar, int patternLength) {
        long newHash = (prevHash - oldChar) / PRIME;

        newHash += newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    /**
     * Searches for a pattern in a given text using the Karp-Rabin algorithm.
     * @param text The text to search for the pattern in.
     * @param pattern The pattern to search for.
     */
    public void search(String text, String pattern) {
        long patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index, " + i);
                }
            }

            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }
}
