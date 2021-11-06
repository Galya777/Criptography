#include <iostream>
#include <cstring>
using namespace std;
const int MAX_LETTERS_FOR_KEY = 10;
const int MAX_LETTERS_PER_WORD = 1000;
char** allocateMatrix(int rows, int cols) {
    char** parr = new (nothrow) char* [rows];
    if (!parr) {
        return nullptr;
    }
    int count = 0;
    for (count = 0; count < rows; count++) {
        parr[count] = new (nothrow) char[cols];
        if (!parr) {
            break;
        }
    } if (count < rows) {
        while (count > 0) {
            count--;
            delete[] parr[count];
        }
        delete[] parr;
        parr = nullptr;
    }
    return parr;
}
void deleteArray(char** pMat, int rows, int colons) {
    for (int i = 0; i < rows; ++i) {
        delete[] pMat[i];
    }
    delete[] pMat;
}
char** Encrypt(const char* text, const char* letters, char** key) {
    char** encrypt = allocateMatrix(strlen(text), MAX_LETTERS_FOR_KEY);
    if (!encrypt) {
        cout << "Not enough memory!";
        return nullptr;
    } for (int i = 0; i < strlen(text); ++i) {
        bool excist = false;
        for (int k = 0; k < strlen(letters); ++k) {
            if (tolower(text[i]) == letters[k]) {
                excist = true;
                for (int j = 0; j < strlen(key[k]); ++j) {
                    encrypt[i][j] = key[k][j];

                    cout << encrypt[i][j];
                }
            }
        } if (excist == false) {
            encrypt[i][0] = text[i]; //we have only one symbol
            cout << encrypt[i][0];
        }
    } cout << endl;
        return encrypt;
        deleteArray(encrypt, strlen(text) + 1, MAX_LETTERS_FOR_KEY);
}
char** Decrypt(const char* text, const char* letters, char** key) {
    char** decrypt = allocateMatrix(strlen(text), MAX_LETTERS_FOR_KEY);
    if (!decrypt) {
        cout << "Not enough memory!";
        return nullptr;
    } int i = 0;
    while( i < strlen(text)) {
        bool excist = false;
        for (int j = 0; j < strlen(letters)/10; ++j) { 
            if (text[i] == key[j][0]) {
                if (strstr(text, key[j]) != 0) {
                    excist = true;
                    decrypt[i][0] = letters[j]; //just one symbol
                    cout << decrypt[i][0];
                    i+=strlen(key[j]);
                }
            }
        }
            if(excist==false) {
                decrypt[i][0] = text[i]; //just one symbol
                cout << decrypt[i][0];
                i++;
            }
        
    }
    return decrypt;
    deleteArray(decrypt, strlen(text) + 1, MAX_LETTERS_FOR_KEY);
}
int main()
{
    int K;
    cout << "Enter the number of letters in ypur key: ";
    cin >> K;
    char** key=allocateMatrix(K+1, MAX_LETTERS_FOR_KEY);
    if (!key) {
        cout << "Not enough memory!";
        return -1;
    }
    char* letters=new (nothrow) char[K];
    if (!letters) {
        cout << "Not enough memory!";
        return -1;
    }  
    for (int i = 0; i < K; ++i) {
        cout << "Enter the letters: ";
        cin >> letters[i];
        while (!isalpha(letters[i])) {
            cout << "Only letters are allowed!";
            cin >> letters[i];
        }
        for (int j = 0; j < strlen(letters); ++j) {
            while (letters[j] == letters[i] && i != j) {
                cout << "No repeating letters!";
                cin >> letters[i];
            }
        }
        cout << "Enter their keys: ";
            cin.ignore();
            cin.getline(key[i], MAX_LETTERS_FOR_KEY);
    }
    int N, M;
    cout << "Enter the number of sentences to be crypted: ";
    cin >> N;
    char** criptword = allocateMatrix(N,MAX_LETTERS_PER_WORD);
    if (!criptword) {
        cout << "Not enough memory!";
        return -1;
    }
    for (int i = 0; i < N; ++i) {
        cin.ignore();
        cin.getline(criptword[i], MAX_LETTERS_PER_WORD);
    }
    cout << "Enter the number of sentences to be decrypted: ";
    cin >> M; 
    char** decriptword = allocateMatrix(M, MAX_LETTERS_PER_WORD);
    if (!decriptword) {
        cout << "Not enough memory!";
        return -1;
    }
    cin.clear();
    for (int i = 0; i < M; ++i) {
        cin.ignore();
        cin.getline(decriptword[i], MAX_LETTERS_PER_WORD);
    }
    for (int i = 0; i < N; ++i) {
        Encrypt(criptword[i], letters, key);
    }
    for (int i = 0; i < M; ++i) {
        if (*Decrypt(decriptword[i], letters, key) == decriptword[i]) {
            cout << "Bad string!" << endl;
        }
        else {
            Decrypt(decriptword[i], letters, key);
        }
    
    }
    deleteArray(criptword, N, MAX_LETTERS_PER_WORD);
    deleteArray( decriptword,M, MAX_LETTERS_PER_WORD);
    deleteArray(key, K + 1, MAX_LETTERS_FOR_KEY);
    delete[] letters;
    return 0;
}

