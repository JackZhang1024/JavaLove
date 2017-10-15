package java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 函数式接口
 * Created by zfz on 2017/2/26.
 */
public class LambdaTest {

    public static void main(String[] args) {
        try {
            String content = processFile((BufferedReader br) -> br.readLine());
            String content2 = processFile((BufferedReader br) -> br.readLine() + br.readLine());
            String content3 = processFile((BufferedReader br) -> {
                StringBuffer stringBuffer = new StringBuffer();
                int count = 0;
                char[] chars = new char[256];
                while ((br.read(chars, 0, chars.length)) != -1) {
                    String line = new String(chars);
                    stringBuffer.append(line);
                }
                return stringBuffer.toString();
            });
            System.out.println("content3 " + content3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String processFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        return br.readLine();
    }

    //使用函数式接口中的方法签名与Lambad表达式签名相同
    @FunctionalInterface
    public interface BufferReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }

    public static String processFile(BufferReaderProcessor processor) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("F:\\JAVALearn\\Learn004\\src\\data.txt"));
        return processor.process(br);
    }

}
