package CipherCesar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import Exception.ReadFileException;


public class FileManager {
    public List<String> readFile(String filePath) {
        Path path = Path.of(filePath);

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new ReadFileException("Ошибка чтения файла");
        }

    }
    public void writeFile(String content, String filePath) {
        try {
            Path path = Path.of(filePath);
            Files.writeString(path,content, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            throw new ReadFileException("Ошибка записи файла");
        }
    }
}
