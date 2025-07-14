package CipherCesar.Exception;

public class ReadFileException extends RuntimeException {

    public ReadFileException(String message) {

        super("Ошибка записи файла");
    }

}
