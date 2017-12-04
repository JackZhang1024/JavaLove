package compositepattern;

/**
 * Created by zfz on 2017/12/12.
 */
public class VideoFile extends AbstractFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile abstractFile) {
        System.out.println("对不起，不支持该操作");
    }

    @Override
    public void remove(AbstractFile abstractFile) {
        System.out.println("对不起，不支持该操作");
    }

    @Override
    public AbstractFile get(int i) {
        System.out.println("对不起，不支持该操作");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("对视频文件 " + name + " 进行杀毒");
    }
}
