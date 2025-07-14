package CipherCesar;

import java.util.HashMap;

public class Cipher {
    private char[] alphabet;
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    private HashMap<Character, Integer> charToIndex;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
        initCharToIndex();
    }

    public Cipher() {
        this.alphabet = ALPHABET;
        initCharToIndex();
    }

    private void initCharToIndex() {
        charToIndex = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            charToIndex.put(alphabet[i], i);
        }
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public int indexOfChar(char c) {
        return charToIndex.getOrDefault(c, -1);
    }

    public String encrypt(String text, int shift) {

        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = indexOfChar(c);
            if (index != -1) {
                int newIndex = (index + shift) % alphabet.length;
                if (newIndex < 0) {
                    newIndex = newIndex + alphabet.length;
                }
                result.append(alphabet[newIndex]);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, -shift);
    }
}
