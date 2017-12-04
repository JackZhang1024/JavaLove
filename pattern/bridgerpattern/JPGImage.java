package bridgerpattern;

/**
 * Created by zfz on 2017/12/12.
 */
public class JPGImage extends Image{

    @Override
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix(); // 模拟解析jpg图片获取一个像素矩阵对象matrix
        imp.doPaint(matrix); // 将像素展示在实现imp接口的系统中
        System.out.println(fileName+" ,格式是jpg");
    }
}
