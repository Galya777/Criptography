class ElGamal:
    def __init__(self, p, g, H):
        '''
        Трите променливи са:
        p - просто число (колкото по-голямо, толкова по-добре)
        g - произволен генератор на факторгрупата на целите числа,
        съставена от класовете на еквивалентност, на които се разбива
        полето на целите числа при сравнение по модул p. Look, Ma', I'm doin' Math!
        H - Collision resistant Хешираща функция.
        Това изречение се чете еднакво на всички езици.
        '''
        self.p = p
        # Числата в интервала [1 : p-1), които са взаимно прости с p-1
        self.coprime_numbers = [i for i in range(1,p-1) if gcd(i, p-1) == 1]
        self.g = g
        self.H = H
        self.private_key = randint(2, self.p-1)
        # pow(a,b,c) <=> (a**b) % c
        self.y = pow(self.g, self.private_key, self.p)
        self.public_key = (self.p, self.g, self.y)
 
    def __str__(self):
        return "ElGamal Signature Scheme with public key: %s" % (self.public_key,)
 
    def sign(self, message):
        while True:
            k = choice(self.coprime_numbers)
            r = pow(self.g, k, self.p)
            s = (
                    (self.H(message) - (self.private_key * r))
                    *
                    reverse_element_in_ring(k, self.p - 1)
                ) % (self.p - 1)
 
            if s != 0:
                x = self.private_key
                return (r,s)
 
    def verify_signature(self, message, signature, public_key):
        r, s = signature
        p, g, y = public_key
 
        if not (0 < r < p and 0 < s < (p - 1)):
            return False
        a = pow(g, self.H(message), p)
        b = pow(y, r, p)
        c = pow(r, s, p)
 
        if a == (b*c) % p:
            return True
        return False
 
Hash = (lambda x: x % 43)
# Очевидно трябва и двамата да са с еднакъв хеш.
eg_sender = ElGamal(101, 2, Hash)
# Реално първите 2 променливи тук са без значение
eg_receiver = ElGamal(23, 3, Hash)
 
# Пробваме 100 пъти подпис и заверка
try:
    for x in range(100):
        message = randint(0, 101)
        signature = eg_sender.sign(message)
        if eg_receiver.verify_signature(message, signature, eg_sender.public_key) == False:
            raise Exception("Грешен резултат по време на опит %s." % x)
 
    # Примерът от задачата
    message = 26
    signature = eg_sender.sign(message)
    if eg_receiver.verify_signature(message, signature, eg_sender.public_key) == False:
        raise "Грешен резултат при message = 26"
except Exception, e:
    print "Съобщението не беше успешно заверено."
    print e
else:
    print "Съобщението беше успешно заверено."
    print "Сто и един пъти."