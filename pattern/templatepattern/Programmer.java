package templatepattern;

/**
 * Created by zfz on 2017/12/17.
 */
public class Programmer extends Work{

    @Override
    protected void doAfternoonWork() {
        System.out.println("下午：程序猿修改Bugs...");
    }

    @Override
    protected void haveRest() {
        System.out.println("中午：程序猿上知乎，看CSDN...");
    }

    @Override
    protected void haveLaunch() {
        System.out.println("午饭：程序猿吃盒饭...");
    }

    @Override
    protected void doMorningWork() {
        System.out.println("早上：程序猿进行紧张的开发工作...");
    }
}
