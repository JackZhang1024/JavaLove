package bridgerpattern;

/**
 * Created by zfz on 2017/12/12.
 */
public class Client {

    public static void main(String[] args) {
        Image image = new JPGImage();
        ImageImpl imp = new WindowsImp();
        image.setImp(imp);
        image.parseFile("黄蓉.jgp");

        Image image2 = new PNGImage();
        ImageImpl imp2 =new LinuxImp();
        image2.setImp(imp2);
        image2.parseFile("郭靖.png");

        Image image3 = new GIFImage();
        ImageImpl imp3 =new UnixImp();
        image3.setImp(imp3);
        image3.parseFile("郭靖.gif");
    }


}
