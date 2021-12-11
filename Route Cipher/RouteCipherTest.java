package Homework3;

import java.util.Scanner;

public class RouteCipherTest {
    public static void main(String[] args) {
        String command;
        int key;
        String text;
        Scanner input= new Scanner(System.in);
        System.out.println("Will you encrypt or decrypt?");
        command=input.next();
        if(command.equals("encrypt")) {
            System.out.print("Enter key: ");
            key = input.nextInt();
            System.out.print("Enter plain text: ");
            text = input.next();


           RouteCipher encr= new RouteCipher(key);
           System.out.println(encr.encrypt(text));

        } else if(command.equals("decrypt")) {
            System.out.print("Enter text: ");
            text = input.next();
            System.out.print("Enter key: ");
            key = input.nextInt();

            RouteCipher encr= new RouteCipher(key);
            System.out.println(encr.decrypt(text));

        }
    }
}
