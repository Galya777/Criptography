class RSA:
    def __init__(self, n, e, padding = (lambda x: x), reverse_padding = (lambda x: x)):
        self.n, self.e = n, e
        self.padding, self.reverse_padding = padding, reverse_padding
        self.phi = phi(factors = find_prime_factors(n))
        self.d = get_reverse_element(e, self.phi)
 
    def encrypt(self, message):
        return [pow(self.padding(letter), self.e, self.n) for letter in message]
 
    def decrypt(self, message):
        return [self.reverse_padding(power(letter, self.d, self.n)) for letter in message]

        from utils import egcd, phi, reverse_element_in_ring
 
def find_prime_factors(num):
    '''
    Връща речник от простите делители на num.
    Ключовете в този речник са делители, а стойностите - коефиценти.
    find_prime_factors(12) = {2:2, 3:1}.
    Сложност: O(Най-големия делител на N)
    '''
    divisors = {}
    if not num % 2:
        divisors[2] = 0
        while not num % 2:
            num /= 2
            divisors[2] += 1
    x = 3
    while x*x <= num:
        if not num % x:
            divisors[x] = 0
            while not num % x:
                num /= x
                divisors[x] += 1
        x += 2
    if num > 1:
        divisors[num] = 1
    return divisors
 
class RSA:
    def __init__(self, n, e, padding = (lambda x: x), reverse_padding = (lambda x: x)):
        self.n, self.e = n, e
        self.padding, self.reverse_padding = padding, reverse_padding
        # Функцията на Ойлер за N.
        self.phi = phi(factors = find_prime_factors(n))
        # Обратния елемент на E по модул PHI. Това се търси в условието
        self.d = reverse_element_in_ring(e, self.phi)
 
    def __str__(self):
        return '''RSA Encryption.
n: %s, phi: %s
e: %s, d: %s''' % (self.n, self.phi, self.e, self.d)
 
    def encrypt(self, message):
        '''
        Всяка част от съобщението ("буква") се подава на padding функцията.
        Резултатът е m.
        След това се връща m**e % n.
        '''
        return [pow(self.padding(letter), self.e, self.n) for letter in message]
 
    def decrypt(self, message):
        '''
        За всяка буква c се смята c**d % n. Това е равно на m**(e*d) % n.
        Равно на m**(phi + 1) % n = m*(m**phi) % n = m % n.
        След това, полученият резултат се прекарва през обратната на padding фунцкията.
        '''
        return [self.reverse_padding(pow(letter, self.d, self.n)) for letter in message]
 
def padding(x):
    # lambda x:
    return (ord(x[1]) - ord('a'))*26 + (ord(x[0]) - ord('a'))
 
def reverse_padding(x):
    return (chr(x%26 + ord("a")), chr(x/26 + ord("a")))
 
rsa = RSA(n = 899, e = 611, padding = padding, reverse_padding = reverse_padding)
 
#Печата параметрите на шифъра. rsa.d се търси в условието
print rsa
 
text = [106, 680, 303]
decrypted_text = rsa.decrypt(text)
 
print '----------------------------------'
# Това, което се търси в условието
print text
print "".join("".join(tup) for tup in decrypted_text)
 
encrypted_text = rsa.encrypt(decrypted_text)
 
if encrypted_text != text:
    # Ако всичко е наред, до тук няма да се стигне
    print "Error! Криптиране и Декриптиране не са обратни една на друга операции!"