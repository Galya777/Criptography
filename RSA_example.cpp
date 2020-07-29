#include<iostream>
#include<math.h>
using namespace std;
// намиране на най-голям общ делител
int gcd(int a, int b) {
	int t;
	while (1) {
		t = a % b;
		if (t == 0)
			return b;
		a = b;
		b = t;
	}
}
int main() {
	double p;
	double q;
	cout << "Enter two prime numbers:" << endl;
	cin >> p >> q;
	double n = p * q;
	double track;
	double phi = (p - 1) * (q - 1);
	double encription_key;
	cin >> encription_key;
	//for checking that 1 < e < phi(n) and gcd(e, phi(n)) = 1; i.e., e and phi(n) are coprime.
	while (encription_key < phi) {
		track = gcd(encription_key, phi);
		if (track == 1)
			break;
		else
			encription_key++;
	}
	//private key
	//d stands for decrypt
	//choosing d such that it satisfies d*e = 1 mod phi
	double d1 = 1 / encription_key;
	double decription_key = fmod(d1, phi);
	double message;
	cout << "Enter your message!" << endl;
	cin >> message;
	double c = pow(message, encription_key); //encrypt the message
	double m = pow(c, decription_key);
	c = fmod(c, n);
	m = fmod(m, n);
	cout << "Original Message = " << message;
	cout << "\n" << "p = " << p;
	cout << "\n" << "q = " << q;
	cout << "\n" << "n = pq = " << n;
	cout << "\n" << "phi = " << phi;
	cout << "\n" << "e = " << encription_key;
	cout << "\n" << "d = " << decription_key;
	cout << "\n" << "Encrypted message = " << c;
	cout << "\n" << "Decrypted message = " << m;
	return 0;
}