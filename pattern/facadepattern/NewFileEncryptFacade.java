package facadepattern;

/**
 * 加密系统的新的外观类
 * Created by zfz on 2017/12/11.
 */
public class NewFileEncryptFacade implements AbstractFileEncryptFacade {

    private FileReader fileReader;
    private FileWriter fileWriter;
    private NewCipherMachine cipherMachine;

    public NewFileEncryptFacade() {
        fileReader = new FileReader();
        cipherMachine = new NewCipherMachine();
        fileWriter = new FileWriter();
    }

    @Override
    public void encryptFile(String fileNameSrc, String fileNameDest) {
        String plainText = fileReader.read(fileNameSrc);
        String cipheredText = cipherMachine.encrypt(plainText);
        fileWriter.write(cipheredText, fileNameDest);
    }

}
