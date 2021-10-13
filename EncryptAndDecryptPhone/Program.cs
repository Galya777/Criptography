using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EncryptAndDecryptA4DigitNumber;

namespace EncryptAndDecryptA4DigitNumber
{
    public class Program
    {
        public static void Main()
        {
            
            Console.WriteLine("Encrypt numbers");
            Encrypt encrpyptPhone;
            int number;
            number = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine(number);
            encrpyptPhone = new Encrypt();
            Console.WriteLine($"Original number: {number} \n" +
                               $"Encrypted number: {encrpyptPhone.EncryptPhone(number)}");

            Console.WriteLine("Decrypt numbers");
            Encrypt decrpyptPhone;
            int crypted;
            crypted = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine(crypted);
            decrpyptPhone = new Encrypt();
            Console.WriteLine($"Encrypted number: {crypted} \n" +
                               $"Original number: {decrpyptPhone.Decrypt(crypted)}");


            
        }



    }
}
