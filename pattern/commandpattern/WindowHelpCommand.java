package commandpattern;

/**
 * Created by zfz on 2017/12/16.
 */
public class WindowHelpCommand extends Command {
    private WindowHelper windowHelper = new WindowHelper();

    @Override
    public void execute() {
        windowHelper.help();
    }
}
