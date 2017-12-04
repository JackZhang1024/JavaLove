package commandpattern;

/**
 * Created by zfz on 2017/12/16.
 */
public class WindowMinimizeCommand extends Command {
    private MinimizeHelper minimizeHelper = new MinimizeHelper();

    @Override
    public void execute() {
        minimizeHelper.minimize();
    }
}
