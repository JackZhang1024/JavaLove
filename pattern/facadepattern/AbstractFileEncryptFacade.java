package facadepattern;

/**
 * 抽象外观类
 * Created by zfz on 2017/12/11.
 */
public interface AbstractFileEncryptFacade {

    public abstract void encryptFile(String fileNameSrc, String fileNameDest);
}
