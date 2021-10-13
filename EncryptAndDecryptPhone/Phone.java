package zad3;

import java.util.Scanner;

public class Phone {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int number;
        System.out.println("Enter a 4-digit number: ");
        number=input.nextInt();
        int fourth=number%10;
        number/=10;
        int third= number%10;
        number/=10;
        int second=number%10;
        int first=number/10;
        fourth= (fourth+7)%10;
        third = (third+7)%10;
        second = (second+ 7)%10;
        first = (first + 7)%10;
        int newNumber= third*1000+ fourth* 100+first*10+second;
        System.out.printf("Encrypted number is %04d",newNumber);

        int encrypted;
        System.out.println("\nEnter a 4-digit number: ");
        encrypted=input.nextInt();
        fourth=encrypted%10;
        number/=10;
        third= encrypted%10;
        number/=10;
        second=encrypted%10;
        first=encrypted/10;
        int temp = first;
        first= third;
        third=temp;
        temp= second;
        second=fourth;
        fourth=temp;
        if(first>=0&&first<=6){
            first+=10;
        } if(second>=0&&second<=6){
            second+=10;
        }if(third>=0&&third<=6){
            third+=10;
        }if(fourth>=0&&fourth<=6){
            fourth+=10;
        }
        first-=7;
        second-=7;
        third-=7;
        fourth-=7;
        int decrypted= first* 1000+ second*100+third*10+ fourth;
        System.out.printf("Decrypted number is %04d",decrypted);
    }
}

