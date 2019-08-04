package kz.eduard.first.pool;

public class NotCorrectConnection extends Exception {
  public NotCorrectConnection() {
    super();
  }

  public NotCorrectConnection(String message) {
    super(message);
  }

  public NotCorrectConnection(String message, Throwable cause) {
    super(message, cause);
  }

  public NotCorrectConnection(Throwable cause) {
    super(cause);
  }
}
