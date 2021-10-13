using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EncryptAndDecryptA4DigitNumber
{
    public class Encrypt
    {
      public string EncryptPhone(int fourDigitNumber)
        {
            string code = "";
            int digit1;
            int digit2;
            int digit3;
            int digit4;
            digit1 = fourDigitNumber % 10;
            fourDigitNumber /= 10;
            digit2 = fourDigitNumber % 10;
            fourDigitNumber /= 10;
            digit3 = fourDigitNumber % 10;
            digit4 = fourDigitNumber / 10;

            digit1 = (digit1 + 7) % 10;
            digit2 = (digit2 + 7) % 10;
            digit3 = (digit3 + 7) % 10;
            digit4 = (digit4 + 7) % 10;
            Console.WriteLine("{2} {3} {0} {1}", digit4, digit3, digit2, digit1);
            return code;
        }

        public string Decrypt(int fourDigitNum)
        {
            string code = "";
            int digit1;
            int digit2;
            int digit3;
            int digit4;
            digit1 = fourDigitNum % 10;
            fourDigitNum /= 10;
            digit2 = fourDigitNum % 10;
            fourDigitNum /= 10;
            digit3 = fourDigitNum % 10;
            digit4 = fourDigitNum / 10;

            int temp = digit1;
            digit1 = digit3;
            digit3 = temp;
            temp = digit2;
            digit2 = digit4;
            digit4 = temp;
            if (digit1 >= 0 && digit1 <= 6)
            {
                digit1 += 10;
            }
            if (digit2 >= 0 && digit2 <= 6)
            {
                digit2 += 10;
            }
            if (digit3 >= 0 && digit3 <= 6)
            {
                digit3 += 10;
            }
            if (digit4 >= 0 && digit4 <= 6)
            {
                digit4 += 10;
            }
            digit1 -= 7;
            digit2 -= 7;
            digit3 -= 7;
            digit4 -= 7;
            int decrypted = digit4 * 1000 + digit3 * 100 + digit2 * 10 + digit1;
            Console.WriteLine(decrypted);
            return code;
        }
    }
}
