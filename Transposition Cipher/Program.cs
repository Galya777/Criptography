using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Transposition_Cipher
{
   public class Program
    {
       public static void Main(string[] args)
        {
            
                String plainText;
                String keyText;
                String command;
              
                Console.WriteLine("Will you encrypt or decrypt?");
                command = Console.ReadLine();
                if (command=="encrypt")
                {
                    Console.WriteLine("Enter plain text: ");
                    plainText = Console.ReadLine();
                    Console.WriteLine("Enter key text: ");
                    keyText = Console.ReadLine();

                TransCipher transCipher = new TransCipher(plainText, keyText);
                Console.WriteLine(transCipher.encrypt(plainText, keyText, '.'));

                }
                else if (command=="decrypt")
                {
                    Console.WriteLine("Enter plain text: ");
                    plainText = Console.ReadLine();
                Console.WriteLine("Enter key text: ");
                    keyText = Console.ReadLine();
                TransCipher transCipher = new TransCipher(plainText, keyText);
                    Console.WriteLine(transCipher.decrypt(plainText,keyText));

                }

            }
        
    }
}
