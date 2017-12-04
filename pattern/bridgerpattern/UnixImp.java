package bridgerpattern;

/**
 * 先解析 然后展示图片
 * Created by zfz on 2017/12/12.
 */
public class UnixImp implements ImageImpl{

    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("在Unix系统中展示图片");
    }
}
