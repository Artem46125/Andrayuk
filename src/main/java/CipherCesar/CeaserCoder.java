package CipherCesar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CeaserCoder {
    private Cipher cipher;
    private FileManager fileManager;
    private BruteForce bruteForce;
    private Validator validator;
    private Set<String> dictionary;
    private char[] alphabet;

    public CeaserCoder() {
        this.cipher = new Cipher();
        this.dictionary = new HashSet<>(); // или загрузите словарь
        this.fileManager = new FileManager();
        this.validator = new Validator();
        this.bruteForce = new BruteForce(dictionary);
        this.alphabet = cipher.getAlphabet();
    }

    public CeaserCoder(Cipher cipher, Set<String> dictionary) {
        this.cipher = cipher;
        this.dictionary = dictionary != null ? dictionary : new HashSet<>();
        this.fileManager = new FileManager();
        this.validator = new Validator();
        this.bruteForce = new BruteForce(this.dictionary);
        this.alphabet = cipher.getAlphabet();
    }

    public void encrypt(String inputFileName, String outputFileName, int key) {
        validator.isFileExists(inputFileName);
        validator.isFileExists(outputFileName);

        List<String> sourceLines = fileManager.readFile(inputFileName);
        List<String> encryptedLines = new ArrayList<>();
        for (String sourceLine : sourceLines) {
            String encryptedLine = cipher.encrypt(sourceLine, key);
            encryptedLines.add(encryptedLine);
        }
        String content = String.join(System.lineSeparator(), encryptedLines);
        fileManager.writeFile(content, outputFileName);
    }

    public void decrypt(String inputFileName, String outputFileName, int key) {
        validator.isFileExists(inputFileName);
        validator.isFileExists(outputFileName);

        List<String> sourceLines = fileManager.readFile(inputFileName);
        List<String> decryptedLines = new ArrayList<>();
        for (String sourceLine : sourceLines) {
            String decryptedLine = cipher.decrypt(sourceLine, key);
            decryptedLines.add(decryptedLine);
        }
        String content = String.join(System.lineSeparator(), decryptedLines);
        fileManager.writeFile(content, outputFileName);
    }

    public void bruteForce(String inputFileName, String outputFolderPath) {

        validator.isFileExists(inputFileName);

        List<String> sourceLines = fileManager.readFile(inputFileName);

        for (int possibleKey = 1; possibleKey <= alphabet.length; possibleKey++) {
            List<String> decryptedLines = new ArrayList<>();
            for (String line : sourceLines) {
                String decryptedLine = bruteForce.decryptWithShift(line, possibleKey, alphabet);
                decryptedLines.add(decryptedLine);
            }
            String content = String.join(System.lineSeparator(), decryptedLines);

            if (bruteForce.evaluate(content) > 0) {
                String outputPath = outputFolderPath + "/decrypted_with_key_" + possibleKey + ".txt";
                fileManager.writeFile(content, outputPath);
                System.out.println("Подходящий ключ: " + possibleKey + ". Результат сохранен в: " + outputPath);
                return;
            }
        }
        System.out.println("Подходящий ключ не найден");
    }
}
