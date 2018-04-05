package prototype;

import java.io.*;

/**
 * Created by zfz on 2017/12/10.
 */
public class WeeklyLogs implements Serializable {

    private String date;
    private String title;
    private String content;
    private Attachment attachment;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    // 通过字节数组输入输出流来读写对象
    public WeeklyLogs deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object object = ois.readObject();
            return (WeeklyLogs) object;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
