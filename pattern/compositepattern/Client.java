package compositepattern;

/**
 * Created by zfz on 2017/12/12.
 */
public class Client {

    public static void main(String[] args) {
        AbstractFile file1, file2, file3, folder1, folder2, folder3;
        file1 = new ImageFile("小龙女");
        file2 = new ImageFile("段誉");
        file3 = new VideoFile("射雕英雄传");
        folder1 = new Folder("图片文件夹");
        folder2 = new Folder("视频文件夹");
        folder1.add(file1);
        folder1.add(file2);
        folder2.add(file3);
        folder3 = new Folder("根目录");
        folder3.add(folder2);
        folder3.add(folder1);

        folder3.killVirus(); // 从根目录处开始杀毒

    }
}
