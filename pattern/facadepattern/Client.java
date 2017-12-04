package facadepattern;

/**
 * Created by zfz on 2017/12/11.
 */
public class Client {

    public static void main(String[] args) {
        encrypt();
        //newEncrypt();
    }

    private static void encrypt() {
        FileEncryptFacade fileEncryptFacade = new FileEncryptFacade();
        fileEncryptFacade.encryptFile("cipher_src.txt", "cipher_dest.txt");
    }

    private static void newEncrypt() {
        NewFileEncryptFacade fileEncryptFacade = new NewFileEncryptFacade();
        fileEncryptFacade.encryptFile("cipher_src.txt", "cipher_dest.txt");
    }
}
