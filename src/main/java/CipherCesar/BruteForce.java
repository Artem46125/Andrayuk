package CipherCesar;

import java.util.HashMap;
import java.util.Set;

public class BruteForce {
    private Set<String> dictionary;

    public BruteForce(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public String decryptByBruteForce(String encryptedText, char[] alphabet) {
        String bestDecryption = "";
        int bestScore = -1;
        int maxKey = alphabet.length - 1;

        for (int key = 1; key <= maxKey; key++) {
            String decryptedCandidate = decryptWithShift(encryptedText, key, alphabet);
            int score = evaluate(decryptedCandidate);
            if (score > bestScore) {
                bestScore = score;
                bestDecryption = decryptedCandidate;
            }
        }
        return bestDecryption;
    }

    String decryptWithShift(String text, int shift, char[] alphabet) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            indexMap.put(alphabet[i], i);
        }

        for (char c : text.toCharArray()) {
            if (indexMap.containsKey(c)) {
                int originalIndex = (indexMap.get(c) - shift + alphabet.length) % alphabet.length;
                result.append(alphabet[originalIndex]);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    int evaluate(String text) {
        String[] words = text.toLowerCase().split("\\W+");
        int count = 0;
        for (String word : words) {
            if (dictionary.contains(word)) {
                count++;
            }
        }
        return count;
    }
}


