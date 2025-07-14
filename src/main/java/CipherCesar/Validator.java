package CipherCesar;

import java.io.File;

public class Validator {
    public boolean isValidKey(int key, char[] alphabet) {
        return key > 0 && key <= alphabet.length - 1;
    }

    public boolean isFileExists(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Файл существует");
            return true;
        } else {
            System.out.println("Файла нет");
        }
        return false;
    }
}
