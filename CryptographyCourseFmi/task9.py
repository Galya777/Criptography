def calculate_secret_key(b_poly, a_key, modulo):
    '''
    Изчислява тайния ключ при комуникация между A и B,
    ако B праща полинома b_poly, а A праща ключа a_key.
    Използва се схемата на Diffie-Hellman.
    Резултатът всъщност е равен на (b_poly ** a_key) % modulo.
    b_poly е списък от двойки (степен, коефицент).
    '''
    return (b_poly ** a_key) % modulo
 
def poly_to_bin(poly, digits):
    def helper(a):
        if a == a.__class__(0):
            return "0"
        else:
            return "1"
    return "".join([helper(poly[pow]) for pow in range(digits)])
 
if __name__ == "__main__":
    #GaloaField просто е полето съставено от {0, 1}
    secret_key = calculate_secret_key(
                Polynomial([[1,1],[5,1],[7,1]], GaloaField),
                2,
                Polynomial([[10,1],[3,1],[0,1]], GaloaField)
            )
    print secret_key
    print poly_to_bin(secret_key, 10)