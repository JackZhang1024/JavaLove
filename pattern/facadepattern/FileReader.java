package facadepattern;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by zfz on 2017/12/11.
 */
public class FileReader {

    public String read(String fileNameSrc){
        System.out.println("读取文件， 读取明文");
        InputStreamReader isr = null;
        BufferedReader br = null;
        String content = null;
        try {
            isr =new InputStreamReader(new FileInputStream(fileNameSrc));
            br = new BufferedReader(isr);
            content = br.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (isr!=null){
                    isr.close();
                }
                if (br !=null){
                    br.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return content;
    }

}
