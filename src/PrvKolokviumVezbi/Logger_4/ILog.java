package PrvKolokviumVezbi.Logger_4;

public interface ILog {
    String getType();
    long getTimestamp();
    String getMessage();
    void setMessage(String newMessage);
}
