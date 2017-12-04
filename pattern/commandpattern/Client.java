package commandpattern;

/**
 * Created by zfz on 2017/12/16.
 */
public class Client {

    public static void main(String[] args) {
        SButton sButton1 = new SButton("功能键1");
        SButton sButton2 = new SButton("功能键2");

        sButton1.setCommand(new WindowMinimizeCommand());
        sButton2.setCommand(new WindowHelpCommand());

        SBPanelSettings sbPanelSettings = new SBPanelSettings();
        sbPanelSettings.addSBInvoker(sButton1);
        sbPanelSettings.addSBInvoker(sButton2);

        sbPanelSettings.display();

        sButton1.onClick();
        sButton2.onClick();

    }

}
