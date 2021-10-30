package zad1;

import java.util.Locale;
import java.util.Scanner;

public class CeasarCipherTest {
    public static void main(String[] args) {
        CeasarCipher.Encrypt("TOY");
        CeasarCipher.Decrypt("WRB");

        Scanner input=new Scanner(System.in);
        int choise;
        while(true){
            do{
                System.out.print("Pick 1 for encryption, 2 for decryption or 3 to exit the program: ");
                choise=input.nextInt();
            }while(choise>3||choise<1);

            switch (choise){
                case 1:
                    System.out.print("Enter word to encrypt: ");
                    String word= input.next();
                    word= word.toUpperCase();
                    CeasarCipher.Encrypt(word);
                    break;
                case 2:
                    System.out.print("Enter word to decrypt: ");
                    String wordToDec= input.next();
                    wordToDec= wordToDec.toUpperCase();
                    CeasarCipher.Encrypt(wordToDec);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
