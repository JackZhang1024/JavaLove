package templatepattern;

/**
 * Created by zfz on 2017/12/17.
 */
public class BossWorker extends Work{

    @Override
    protected void doAfternoonWork() {
        System.out.println("下午：Boss看公司业务，开会");
    }

    @Override
    protected void haveRest() {
        System.out.println("中午：Boss午间看报学习");
    }

    @Override
    protected void haveLaunch() {
        System.out.println("午饭：Boss咖啡厅和投资人见面");
    }

    @Override
    protected void doMorningWork() {
        System.out.println("早上：Boss选股票进行投资");
    }

    @Override
    protected boolean isBoss() {
        return true;
    }
}
