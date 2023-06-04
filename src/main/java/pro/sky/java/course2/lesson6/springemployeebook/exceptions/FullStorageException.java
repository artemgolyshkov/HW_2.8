package pro.sky.java.course2.lesson6.springemployeebook.exceptions;

public class FullStorageException extends RuntimeException {
    public FullStorageException() {
    }

    public FullStorageException(String message) {
        super(message);
    }

    public FullStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullStorageException(Throwable cause) {
        super(cause);
    }

    public FullStorageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
