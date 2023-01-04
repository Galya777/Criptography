package randomcipher;

import java.util.Locale;

public class Encryption {

    private static class MonoEncryption implements IEncryptable{
        final int ALPHABET = 26; //size of english alphabet
        final int A_ASCII = 65; //ASCII number of letter A

        @Override
        public String encrypt(String plainText, String cipher) {
            //converting the cipher and the plain text to upper case to make sure everything works correctly
            cipher = cipher.toUpperCase(Locale.ROOT);
            plainText = plainText.toUpperCase(Locale.ROOT);

            int[] cipherArr = makeCipher(cipher);
            char[] plainTextArr = plainText.toCharArray();
            char[] cipheredTextArr = new char[plainText.length()];

            for(int i = 0;i < cipheredTextArr.length;i++){
                cipheredTextArr[i] = (char) cipherArr[(int)plainTextArr[i] - A_ASCII];
            }

            return new String(cipheredTextArr);
        }

        @Override
        public String decrypt(String cipherText, String cipher) {
            //converting the cipher and the plain text to upper case to make sure everything works correctly
            cipher = cipher.toUpperCase(Locale.ROOT);
            cipherText = cipherText.toUpperCase(Locale.ROOT);

            int[] cipherArr = makeCipher(cipher);
            char[] cipherTextArr = cipherText.toCharArray();
            char[] decipheredTextArr = new char[cipherText.length()];

            for(int i = 0;i < decipheredTextArr.length;i++){
                for(int j = 0;j < cipherArr.length; j++){
                    if(cipherArr[j] == cipherTextArr[i]){
                        decipheredTextArr[i] = (char) (j + A_ASCII);
                    }
                }
            }

            return new String(decipheredTextArr);
        }

        private int[] getCounts(String cipher){
    // returns a int[26] array of counts a letter appears in cipher
           int[] appear = new int[26];
           char[] alphabet=new char[26];

           for(int i=0; i< 26;++i){
               appear[i]=0;
               alphabet[i]= (char) (A_ASCII+i);
           }
           for(int i=0; i<cipher.length();++i){
               for(int j=0; j<cipher.length();++j) {
                   if (cipher.charAt(i) == alphabet[j]){
                    appear[j]++;
                   }

               }
           }
           return appear;
        }
        private int[] makeCipher(String cipher){
// returns a int[26] array representing the cipher pad map
// over the standard English alphabet
// всеки елемент има стойност равна на позицията на буква
// от азбуката, която съответства на неговия индекс в cipher pad
// позицията на letter е отместването й спрямо ‘A’ т.е.
// letterChar – ‘A’
// calls getCounts() to build the first part of the cipher pad
            char[] cipherCharArr = cipher.toCharArray(); //to store the cipher word as char array
            char[] cipherArr = new char[ALPHABET]; //to create the cipher that will be used to cipher/decipher
            boolean[] existingLetters = new boolean[ALPHABET]; //to keep track of the letters already in the cipher

            int count = 0;

            for (char c : cipherCharArr) { //places the letters of the cipher word in the beginning of the cipher

                if (!existingLetters[(int) c - A_ASCII]) {//checks if loop has already encountered the letter
                    existingLetters[(int) c - A_ASCII] = true; //and removes repeating letters
                    cipherArr[count] = c;
                    count++;
                }
            }

            int letter = (int)'Z';

            for(int i = count;i < cipherArr.length; i++){ //fills the cipher with the remaining letters from the alphabet
                // starting from Z
                if(!existingLetters[letter  - A_ASCII]){
                    cipherArr[i] = (char) letter;
                    existingLetters[letter - A_ASCII] = true;
                    letter--;
                }else {
                    i--;
                    letter--;
                }
            }

            return new int[]{Integer.parseInt(String.valueOf(cipherArr))};
        }
    }
    IEncryptable getMonoCipher(){
        return (IEncryptable) new MonoEncryption();
    }
}
