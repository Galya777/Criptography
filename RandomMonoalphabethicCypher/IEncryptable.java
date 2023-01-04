package randomcipher;

public interface IEncryptable {

    String encrypt(String plainText, String cipher);
    // returns the encrypted string
    String decrypt(String cipherText, String cipher);
// returns the decrypted string
}
