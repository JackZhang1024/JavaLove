package prototype;

/**
 * Created by zfz on 2017/12/10.
 */
public class Client {

    public static void main(String[] args) {
       lightClone();
       deepClone();
    }

    private static void lightClone(){
        WeeklyLog previous_weeklog = new WeeklyLog();
        previous_weeklog.setDate("2017-12-10");
        previous_weeklog.setTitle("第一周周报");
        previous_weeklog.setContent("完成第一章");
        Attachment attachment = new Attachment();
        attachment.setName("第一周附件");
        previous_weeklog.setAttachment(attachment);

        WeeklyLog new_weeklog = previous_weeklog.clone();
        new_weeklog.setDate("2017-12-11");
        System.out.println("new_weeklog Date   "+new_weeklog.getDate());
        System.out.println("new_weeklog Title  "+new_weeklog.getTitle());
        System.out.println("new_weeklog Content"+new_weeklog.getContent());
        System.out.println("previous==new      "+(previous_weeklog==new_weeklog));
        System.out.println("previous==new      "+(previous_weeklog.getAttachment()==new_weeklog.getAttachment()));
    }

    private static void deepClone(){
        WeeklyLogs weeklyLogs = new WeeklyLogs();
        weeklyLogs.setDate("2017-12-10");
        weeklyLogs.setTitle("第一周周报");
        weeklyLogs.setContent("完成第一章");
        Attachment attachment = new Attachment();
        attachment.setName("第一周附件");
        weeklyLogs.setAttachment(attachment);

        WeeklyLogs newWeeklyLogs = weeklyLogs.deepClone();
        newWeeklyLogs.setDate("2017-12-11");
        System.out.println("weeklyLogs == newWeeklyLogs "+(weeklyLogs==newWeeklyLogs));
        System.out.println("previous==new      "+(weeklyLogs.getAttachment()==newWeeklyLogs.getAttachment()));
    }


}
