package zad3;

public class TransCipher {
    String plainText;
    String keyText;


    public TransCipher(String plainText, String keyText) {
        setPlainText(plainText);
        setKeyText(keyText);
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getKeyText() {
        return keyText;
    }

    public void setKeyText(String keyText) {
        this.keyText = keyText;
    }

    void encrypt() {
        int cipherKey = keyText.length();

        char[] toCipher = plainText.toCharArray();
        int rowlength;
        int length = plainText.length();

        if (length % cipherKey == 0) {
            rowlength = length / cipherKey;
        } else {
            rowlength = length / cipherKey + 1;
        }
        char[][] encryptedText = new char[rowlength][cipherKey];
        int rowCounter = 0;
        for (int i = 0; i < toCipher.length; ++i) {
            if (i != 0 && i % cipherKey == 0) {
                rowCounter++;
            }
            encryptedText[rowCounter][i % cipherKey] = toCipher[i];
        }
        for (int i = 0; i < encryptedText.length; i++) {
            for (int j = 0; j < encryptedText[i].length; j++) {
                System.out.print(encryptedText[i][j] + " ");
            }
            System.out.println();
        }

        String cipheredText = "";
        for (int i = 0; i < encryptedText[0].length; i++) {
            for (int j = 0; j < encryptedText.length; j++) {
                cipheredText += encryptedText[j][i];
            }
        }
        //thisistheplaintext
        System.out.println("Cipher: " + cipheredText);
    }

    void decrypt() {
        int min, i, j, k;
        char key[] = keyText.toCharArray();
        char encry[] = plainText.toCharArray();
        char temp;
        // Step 4: Generating a plain message
        int row = keyText.length();
        plainText.length();
        char pmat[][]
                = new char[row][(plainText.length())];
        int tempcnt = -1;

        for (i = 0; i < keyText.length(); i++) {
            for (k = 0; k < keyText.length(); k++) {
                if (i == encry[k]) {
                    break;
                }
            }

            for (j = 0; j < row; j++) {
                tempcnt++;
                pmat[j][k] = encry[tempcnt];
            }
        }

        // Step 5: Storing matrix character in
        // to a single string
        char p1[] = new char[row * keyText.length()];

        k = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < keyText.length(); j++) {
                if (pmat[i][j] != '*') {
                    p1[k++] = pmat[i][j];
                }
            }
        }

        p1[k++] = '\0';
        System.out.println("Cipher: " + encry);
    }

}

