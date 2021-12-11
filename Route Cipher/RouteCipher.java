package Homework3;

public class RouteCipher {
    private int cipher;

    public RouteCipher(int cipher) {
        this.cipher = cipher;
    }

    public int getCipher() {
        return cipher;
    }

    public void setCipher(int cipher) {
        this.cipher = cipher;
    }

    public String encrypt(String plainText){
        char [] cipherTextChars =plainText.toCharArray();
        char[] encrypted = new char[cipher* plainText.length()];
        int counter=0;

        for (int rows = 2; rows <= cipher; rows++) {
            for (int repeat = 0; repeat < rows; repeat++) {
                for (int character = repeat; character < plainText.length(); character += rows) {
                    encrypted[counter]=cipherTextChars[character];
                    counter++;
                }
            }
        }
        return new String(encrypted);
    }
    public String decrypt(String cipherText){
        char [] cipherTextChars = cipherText.toCharArray();
        char[] decrypted = new char[cipher* cipherText.length()];
        int counter=0;
        for (int rows = 2; rows <= cipherText.length(); rows++) {
            int columns = (int) Math.ceil(cipher) / (rows);
            for (int i = 0; i < columns; i++) {
                for (int increment = i; increment < cipher; increment += columns) {
                    decrypted[counter]=cipherTextChars[increment];
                    counter++;
                }
            }
        }
        return new String(decrypted);
    }

    @Override
    public String toString() {
        return "RouteCipher{" +
                "cipher=" + cipher +
                '}';
    }
}
