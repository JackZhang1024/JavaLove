package facadepattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by zfz on 2017/12/11.
 */
public class FileWriter {

    public void write(String encryptStr, String fileDestName) {
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(new File(fileDestName)));
            bw = new BufferedWriter(osw);
            bw.write(encryptStr);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
