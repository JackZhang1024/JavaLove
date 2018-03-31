package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 访问百度主页
 * <p>
 * Created by zfz on 2017/12/2.
 */
public class NIOLearn002 {
    private static Charset charset = Charset.forName("GBK");
    private static SocketChannel channel;

    public static void main(String[] args) {
        accessBaiduHome();
    }

    private static void accessBaiduHome() {
        try {
            InetSocketAddress socketAddress = new InetSocketAddress("www.tmall.com", 80);
            // 1. 打开连接
            channel = SocketChannel.open(socketAddress);
            channel.write(charset.encode("GET" + "/HTTP/1.1" + "\r\n\r\n"));
            ByteBuffer buffer = ByteBuffer.allocate(1024*20);
            while (channel.read(buffer)!= -1) {
                buffer.flip(); // flip方法在读取缓存区字节操作之前调用
                System.out.println(charset.decode(buffer)); // charset.decode()方法可以将字节转换称字符串
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
