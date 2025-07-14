package CipherCesar;


public class Main {
    public static void main(String[] args) {
        CeaserCoder ceaserCoder = new CeaserCoder();

        String inputFileName = "C:\\Users\\pavlo\\IdeaProjects\\CipherCesar\\src\\main\\java\\CipherCesar\\Text\\text.txt"; // исходный файл для чтения
        String encryptedFileName = "C:\\Users\\pavlo\\IdeaProjects\\CipherCesar\\src\\main\\java\\CipherCesar\\Text\\encryptedText.txt"; // зашифрованный файл
        String decryptedFileName = "C:\\Users\\pavlo\\IdeaProjects\\CipherCesar\\src\\main\\java\\CipherCesar\\Text\\decrypted.txt"; // расшифрованный файл

        int key = 10;

        try {
            ceaserCoder.encrypt(inputFileName, encryptedFileName, key);
            System.out.println("Файл зашифрован и сохранен в: " + encryptedFileName);
            ceaserCoder.decrypt(encryptedFileName, decryptedFileName, key);
            System.out.println("Файл расшифрован и сохранен в: " + decryptedFileName);
            String inputForBruteForce = encryptedFileName;
            String outputFolderPath = ".";
            ceaserCoder.bruteForce(inputForBruteForce, outputFolderPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}