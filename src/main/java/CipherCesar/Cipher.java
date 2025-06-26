package CipherCesar;

public class Cipher {
    private char[] alphabet;
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public Cipher(char[] alphabet) {
        this.alphabet = ALPHABET;
    }

    public String encrypt(String text, int shift) {
        return null;
    }

    public String decrypt(String encryptedText, int shift) {
        return null;
    }
}
