package zad3;

import java.util.Scanner;

public class TranspositionCipher {
    public static void main(String[] args) {
        String plainText;
        String keyText;
        String command;
        Scanner input= new Scanner(System.in);
        System.out.println("Will you encrypt or decrypt?");
        command=input.next();
        if(command.equals("encrypt")) {
            System.out.print("Enter plain text: ");
            plainText = input.next();
            System.out.print("Enter key text: ");
            keyText = input.next();

            TransCipher transCipher = new TransCipher(plainText, keyText);
            transCipher.encrypt();

        } else if(command.equals("decrypt")) {
            System.out.print("Enter plain text: ");
            plainText = input.next();
            System.out.print("Enter key text: ");
            keyText = input.next();
            TransCipher transCipher = new TransCipher(plainText, keyText);
            transCipher.decrypt();

        }

        }
}
