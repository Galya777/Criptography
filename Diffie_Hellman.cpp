#include<iostream> 
#include<math.h> 

// Функцията a ^ b mod P 
long long int power(long long int a, long long int b,
	long long int P)
{
	if (b == 1) {
		return a;
	}
	else {
		return (((long long int)pow(a, b)) % P);
	}
}

int main()
{
	long long int P, G, x, a, y, b, ka, kb;

	std::cout << "Enter prime number for P"<<std::endl;
	std::cin >> P;
	
	std::cout<<"The value of P : "<< P<<std::endl;

	std::cout << "Enter prime number for G" << std::endl;
	std::cin >> G;
	std::cout<<"The value of G : "<<G<<std::endl;

	std::cout << "Choose the private key a" << std::endl;
	std::cin >> a;
	std::cout<<"The private key a : "<< a;
	x = power(G, a, P); // gets the generated key 

	std::cout << "Choose the private key b" << std::endl;
	std::cin >> b;
	std::cout << "The private key b : " << a;
	y = power(G, b, P); // gets the generated key 

	// Generating the secret key after the exchange 
		// of keys 
	ka = power(y, a, P); // Secret key for a
	kb = power(x, b, P); // Secret key for b

	std::cout<<"Secret key for the Alice is : "<< ka;
	std::cout<<"Secret Key for the Bob is :"<< kb;

	return 0;
}
