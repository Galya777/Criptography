using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RouteCipher
{
    public class Program
    {
        public static void Main(string[] args)
        {
            string command;
            int key;
            string text;
      
            Console.WriteLine("Will you encrypt or decrypt?");
            command = Console.ReadLine();
            if (command.Equals("encrypt"))
            {
                Console.WriteLine("Enter key: ");
                key = Console.Read();
                Console.WriteLine("Enter plain text: ");
                text = Console.ReadLine();


                RouteCipher encr = new RouteCipher(key);
                Console.WriteLine(encr.encrypt(text));

            }
            else if (command.Equals("decrypt"))
            {
                Console.WriteLine("Enter text: ");
                text = Console.ReadLine();
                Console.WriteLine("Enter key: ");
                key = Console.Read();

                RouteCipher encr = new RouteCipher(key);
                Console.WriteLine(encr.decrypt(text));

            }
        }
    }
    
}
