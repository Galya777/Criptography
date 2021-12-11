using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RouteCipher
{
    public class RouteCipher
    {
        private int cipher;

        public RouteCipher(int cipher)
        {
            this.cipher = cipher;
        }

        public int getCipher()
        {
            return cipher;
        }

        public void setCipher(int cipher)
        {
            this.cipher = cipher;
        }

        public string encrypt(string plainText)
        {
            char[] cipherTextChars = plainText.ToCharArray();
            char[] encrypted = new char[cipher * plainText.Length];
            int counter = 0;

            for (int rows = 2; rows <= cipher; rows++)
            {
                for (int repeat = 0; repeat < rows; repeat++)
                {
                    for (int character = repeat; character < plainText.Length; character += rows)
                    {
                        encrypted[counter] = cipherTextChars[character];
                        counter++;
                    }
                }
            }
            return new string(encrypted);
        }
        public string decrypt(string cipherText)
        {
            char[] cipherTextChars = cipherText.ToCharArray();
            char[] decrypted = new char[cipher * cipherText.Length];
            int counter = 0;
            for (int rows = 2; rows <= cipherText.Length; rows++)
            {
                int columns = (cipher) / (rows);
                for (int i = 0; i < columns; i++)
                {
                    for (int increment = i; increment < cipher; increment += columns)
                    {
                        decrypted[counter] = cipherTextChars[increment];
                        counter++;
                    }
                }
            }
            return new string(decrypted);
        }

    }
}
