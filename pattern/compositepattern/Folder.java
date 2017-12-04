package compositepattern;

import java.util.ArrayList;

/**
 * Created by zfz on 2017/12/12.
 */
public class Folder extends AbstractFile {
    private ArrayList<AbstractFile> fileList = new ArrayList<>();
    private String name; // 文件夹名称

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile abstractFile) {
        fileList.add(abstractFile);
    }

    @Override
    public void remove(AbstractFile abstractFile) {
        fileList.remove(abstractFile);
    }

    @Override
    public AbstractFile get(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("对文件夹 "+name+" 开始杀毒");
        for (AbstractFile file : fileList) {
            file.killVirus();
        }
    }
}
