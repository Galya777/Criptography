using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ceasar_Shyper
{
    class Program
    {
       
        static void Main(string[] args)
        {
            CeasarShyper ceasar = new CeasarShyper(3);
            var code = ceasar.Encrypt("TOY");
            Console.WriteLine($"Encrypt TOY: {code}");
            var plain = ceasar.Decrypt(code);
            Console.WriteLine($"Decrypt TOY: {plain}");
        }
    }
}
