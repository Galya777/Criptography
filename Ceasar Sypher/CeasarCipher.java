package zad1;

public class CeasarCipher {
    private static final int SHIFT_LENGTH=3;
    private static final int ALPHABET_LENGTH=26;

    private static char[] alphabet(){
        char[] alphabet= new char[ALPHABET_LENGTH];
        char iter= 'A';
        for(int i=0;i<alphabet.length;++i ){
            alphabet[i] =iter++;
        }
        return alphabet;
    }
    public static void Encrypt(String plainText){
        char[] alphabet= alphabet();
        char[] resultString= plainText.toCharArray();
        int index;
        for(int i=0;i<resultString.length;++i ){
            index=(resultString[i]+SHIFT_LENGTH-'A')%ALPHABET_LENGTH;
            resultString[i] =alphabet[index];
        }
        System.out.println(new String(resultString));
    }
    public static void Decrypt(String cipherText){
        char[] alphabet= alphabet();
        char[] resultString= cipherText.toCharArray();
        int index;
        for(int i=0;i<resultString.length;++i ){
            index=((resultString[i]-SHIFT_LENGTH-'A')+ALPHABET_LENGTH)%ALPHABET_LENGTH;
            resultString[i] =alphabet[index];
        }
        System.out.println(new String(resultString));
    }
}
