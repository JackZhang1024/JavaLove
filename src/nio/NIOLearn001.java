package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 拷贝文件
 * Created by zfz on 2017/12/2.
 */
public class NIOLearn001 {


    public static void main(String[] args) {
        try {
            copyFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyFile() throws Exception {
        String currentPath  = System.getProperty("user.dir");
        String srcFilePath  = currentPath+"\\src\\nio\\src.txt";
        String destFilePath = currentPath+"\\src\\nio\\dest.txt";
        FileInputStream fileInputStream = new FileInputStream(srcFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(destFilePath);
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel destChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int re = inChannel.read(byteBuffer);
            if (re == -1) {
                break;
            }
            byteBuffer.flip();
            destChannel.write(byteBuffer);
        }
    }


}
