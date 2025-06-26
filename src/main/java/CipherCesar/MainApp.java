package CipherCesar;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\pavlo\\IdeaProjects\\CipherCesar\\Text\\text.txt";
        FileManager fileManager = new FileManager();
//        fileManager.readFile(filePath);

        try {
            List<String> list = fileManager.readFile(filePath);
            for (String text: list) {
                System.out.println(text);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
