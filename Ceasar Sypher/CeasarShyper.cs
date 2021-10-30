using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ceasar_Shyper
{
    class CeasarShyper
    {
        private int shift;
        public CeasarShyper(int lenght)
        {
            shift = lenght;
        }
        public int ShiftLength { get { return shift; } set { shift = Math.Abs(value) < 26 ? value : 3; } }
        public string Encrypt(string plainText)
        {
            char[] plaintextChars = plainText.ToCharArray();
            char[] cipherTextCh = new char[plaintextChars.Length];
            for (int i = 0; i < plaintextChars.Length; i++)
            {
                cipherTextCh[i] = (char)('A' + (plaintextChars[i] - 'A' + shift + 26) % 26);
            }
            return new string(cipherTextCh);
        }
        public string Decrypt(string cipherText)
        {
            char[] ciphertextChars = cipherText.ToCharArray();
            char[] plainTextCh = new char[ciphertextChars.Length];
            for (int i = 0; i < ciphertextChars.Length; i++)
            {
                plainTextCh[i] = (char)('A' + (ciphertextChars[i] - 'A' - shift + 26) % 26);
            }

            return new string(plainTextCh);
        }
    }
}
