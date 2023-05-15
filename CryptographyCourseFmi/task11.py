def product(lst):
    return reduce(lambda x,y: x*y, lst)
 
class Shamir:
    def __init__(self, n, k, p = None):
        self.n = n
        self.k = k
        self.p = p
 
    def generate_shares(self, secret, values = []):
        '''
        Генерира N поделени ключове за тайната secret.
        Ако са дадени поне N values, генерира ключовете от тях.
        Иначе ги генерира от [1, 2, ... N]
        '''
        limit = self.p or 10000
        coefs = [(i, randint(0, limit)) for i in reversed(range(1, self.k))] + [(0, secret)]
        poly = Polynomial(coefs)
        if not values or len(values) < n:
            values = range(1, self.n+1)
        return [(val, poly(val)) for val in values[:self.n]], poly
 
    def reveal_secret(self, keys):
        '''
        Връща тайната информация, кодирана в ключовете.
        Хвърля грешка, ако не са подадени достатъчно ключове.
        Връща две неща:
        (тайната информация и полинома, с който е закодирана.)
        Ако е въведено p, връща три неща:
        (тайната информация по модул P, оригиналната тайна и полинома)
        '''
        if len(keys) < self.k:
            class DecryptionImpossible(Exception):
                pass
            raise DecryptionImpossible("Not enough keys given.")
 
        # Генерира полинома на Лагранж
        lagrange = Polynomial(_class = Fraction)
        for ind in range(len(keys)):
            x,y = keys[ind]
            lx = product([Polynomial(
                [
                    (0,- Fraction(keys[i][0], (keys[ind][0] - keys[i][0]))),
                    (1, Fraction(1, (keys[ind][0] - keys[i][0])))
                ]
                )
                for i in range(len(keys)) if i != ind ])
            lagrange += Polynomial([(0,Fraction(y))]) * lx
 
        if self.p:
            # Нормализира полинома - всички едночлени да са от Zp
            normalized_lagrange = Polynomial()
            for power, coef in lagrange:
                normalized_lagrange[power] = (coef.num * reverse_element_in_ring(coef.denum, self.p)) % self.p
        else:
            normalized_lagrange = lagrange
 
        secret = normalized_lagrange[0]
        return (secret, normalized_lagrange)
 
def test():
    '''
    Това е тест, взет от:
    http://en.wikipedia.org/wiki/Shamir%27s_Secret_Sharing
    '''
    shamir = Shamir(6,3)
    secret = 1234
 
    shares, poly = shamir.generate_shares(secret)
    print '''Тайна дума: %s,
Генериращ полином: %s,
Дялове на участниците: %s''' % (secret, poly, shares)
 
    revealed = shamir.reveal_secret(shares[0:3])
    print '''Разкриване на тайната:
Тайна дума: %s
Генериращ полином: %s''' % revealed
 
    if secret != revealed[0].num:
        print("В програмата има грешка. Тайната не може да бъде въстановена.")
    else:
        print("Тайната беше успешно въстановена.")
 
    shamir = Shamir(6,3)
    #Това трябва да изкара 1234
    revealed = shamir.reveal_secret([(2,1942), (4,3402), (3, 2578)])
    if revealed[0].num != 1234:
        print("В програмата има грешка. Тайната не може да бъде въстановена.")
 
if __name__ == "__main__":
    # Търсеното от условието
    shamir = Shamir(n = 6, k = 4, p = 31)
    keys = [(11,14),(7,20),(13,10),(21,6)]
    print shamir.reveal_secret(keys)