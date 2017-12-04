package commandpattern;

/**
 * 命令调用者 功能键
 * Created by zfz on 2017/12/16.
 */
public class SButton {
    private String name;
    private Command command;

    public SButton(String name) {
        this.name = name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onClick() {
        command.execute();
    }

    public String getName() {
        return name;
    }
}
