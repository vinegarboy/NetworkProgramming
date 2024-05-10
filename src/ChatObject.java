import java.io.Serializable;
import java.util.Date;

public class ChatObject implements Serializable{
    Date TimeStamp;
    String message;
    String Author;

    public ChatObject(Date timeStamp, String message, String author) {
        this.TimeStamp = timeStamp;
        this.message = message;
        this.Author = author;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return Author;
    }

    public Date getTimeStamp() {
        return TimeStamp;
    }
}
