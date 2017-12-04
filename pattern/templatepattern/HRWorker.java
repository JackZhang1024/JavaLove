package templatepattern;

/**
 * Created by zfz on 2017/12/17.
 */
public class HRWorker extends Work{

    @Override
    protected void doAfternoonWork() {
        System.out.println("下午：HR 学习心理咨询相关知识");
    }

    @Override
    protected void haveRest() {
        System.out.println("中午：HR午间听听音乐，看看电影");
    }

    @Override
    protected void haveLaunch() {
        System.out.println("午饭：HR和朋友一块吃饭");
    }

    @Override
    protected void doMorningWork() {
        System.out.println("早上：HR准备招聘信息，统计员工考勤");
    }
}
