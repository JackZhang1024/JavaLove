package facadepattern;

/**
 * Created by zfz on 2017/12/11.
 */
public class CipherMachine {

    public String encrypt(String plainText){
        StringBuffer stringBuffer =new StringBuffer();
        for (int index =0; index< plainText.length(); index++){
             char c = plainText.charAt(index);
             stringBuffer.append(c%7);
        }
        return stringBuffer.toString();
    }
}
