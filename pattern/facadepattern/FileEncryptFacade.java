package facadepattern;

/**
 * 加密系统的外观类
 * Created by zfz on 2017/12/11.
 */
public class FileEncryptFacade implements AbstractFileEncryptFacade {

    private FileReader fileReader;
    private FileWriter fileWriter;
    private CipherMachine cipherMachine;

    public FileEncryptFacade() {
        fileReader = new FileReader();
        cipherMachine = new CipherMachine();
        fileWriter = new FileWriter();
    }

    @Override
    public void encryptFile(String fileNameSrc, String fileNameDest) {
        String plainText = fileReader.read(fileNameSrc);
        String cipheredText = cipherMachine.encrypt(plainText);
        fileWriter.write(cipheredText, fileNameDest);
    }

}
