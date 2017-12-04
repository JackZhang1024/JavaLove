package templatepattern;

/**
 * 模板类
 * Created by zfz on 2017/12/17.
 */
public abstract class Work {

    // 老板不需要打卡
    public void workOneDay() {
        if (!isBoss()) {
            checkAttendance();
        }
        doMorningWork();
        haveLaunch();
        haveRest();
        doAfternoonWork();
        if (!isBoss()) {
            checkQuit();
        }
        System.out.println("-------------------------");
    }

    //抽象方法
    protected abstract void doAfternoonWork();

    protected abstract void haveRest();

    protected abstract void haveLaunch();

    protected abstract void doMorningWork();

    //具体方法
    private void checkAttendance() {
        System.out.println("上班打卡");
    }

    //具体方法
    private void checkQuit() {
        System.out.println("下班打卡");
    }

    //钩子方法
    protected boolean isBoss() {
        return false;
    }

}
