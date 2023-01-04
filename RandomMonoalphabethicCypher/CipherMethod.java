package randomcipher;

public class CipherMethod implements IEncryptable{

    IEncryptable callBackFtn;

    public CipherMethod() {
        Encryption encryption = new Encryption();
        callBackFtn = encryption.getMonoCipher();
    }

    @Override
    public String encrypt(String plainText, String cipher) {
        return callBackFtn.encrypt(plainText, cipher);
    }

    @Override
    public String decrypt(String cipherText, String cipher) {
        return callBackFtn.decrypt(cipherText, cipher);
    }
}
