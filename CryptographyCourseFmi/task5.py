from numpy import *
class Feistel:
    def __init__(self, len, h, f):
        # Размерът на елементите, които ще се криптират
        self.len = len
        # Броя стъпки в криптирането
        self.h = h
        # Криптиращата функция
        self.f = f
 
    def split_message(self, message):
        '''
        Прави от първоначалния низ лява и дясна част от числа.
        '''
        message = [ord(letter) - ord('0') for letter in message]
        left, right = message[:len(message)/2],message[len(message)/2:]
        return tuple(left), tuple(right)
 
    def assemble_message(self, left, right):
        '''
        Сглобява лява и дясна част от числа в низ.
        '''
        left = [chr(num + ord('0')) for num in left]
        right = [chr(num + ord('0')) for num in right]
        return "".join(left + right)
 
    def hash(self, left, right, n):
        '''
        Изчислява една стъпка от алгоритъма на Feistel.
        '''
        def XOR(la, lb):
            '''
            Приема 2 списъка и връща списък, с елементи XOR-натите
            съответни техни елементи.
            '''
            return [la[x]^lb[x] for x in range(len(la))]
        def func(l, n):
            tup = [self.f[n][l[x:x+self.len]] for x in range(0,len(l),self.len)]
            return tuple(a for b in tup for a in b )
        return right, tuple(XOR(left, func(right, n)))
 
    def encrypt(self, message):
        left, right = self.split_message(message)
        for x in range(0, self.h):
            left, right = self.hash(left, right, x)
        return self.assemble_message(left, right)
 
    def decrypt(self, message):
        left, right = self.split_message(message)
        for x in reversed(range(0, self.h)):
            right, left = self.hash(right, left, x)
        return self.assemble_message(left, right)
 
# Знам, знам - това е много дълго. Функцията е много дълга, какво да направя :)
feistel = Feistel(2,6, [
                        {(0,0) : (1,0),
                        (0,1) : (1,0),
                        (1,0) : (0,0),
                        (1,1) : (0,1)},
 
                        {(0,0) : (0,1),
                        (0,1) : (1,0),
                        (1,0) : (1,0),
                        (1,1) : (0,0)},
 
                        {(0,0) : (1,1),
                        (0,1) : (0,0),
                        (1,0) : (0,1),
                        (1,1) : (1,0)},
 
                        {(0,0) : (1,1),
                        (0,1) : (1,0),
                        (1,0) : (1,1),
                        (1,1) : (0,1)},
 
                        {(0,0) : (1,1),
                        (0,1) : (0,0),
                        (1,0) : (0,0),
                        (1,1) : (1,0)},
 
                        {(0,0) : (1,1),
                        (0,1) : (1,1),
                        (1,0) : (0,1),
                        (1,1) : (1,0)}]
        )
 
print "0100"
print feistel.encrypt("0100")
print feistel.decrypt(feistel.encrypt("0100"))
 
def test(feistel):
    for x in range(0,16):
        l = ""
        for y in range(4):
            l += chr(ord('0') + x % 2)
            x /= 2
        if feistel.decrypt(feistel.encrypt(l)) != l:
            print "ERROR!"
        return False
    return True