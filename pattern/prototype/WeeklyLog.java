package prototype;

/**
 * Created by zfz on 2017/12/10.
 */
public class WeeklyLog implements Cloneable {
    private String date;
    private String title;
    private String content;
    private Attachment attachment;


    @Override
    protected WeeklyLog clone() {
        Object object = null;
        try {
            object = super.clone();
            return (WeeklyLog) object;
        }catch (CloneNotSupportedException e){
            return null;
        }
    }

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

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }
}
