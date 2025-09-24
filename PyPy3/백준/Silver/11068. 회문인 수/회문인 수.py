import sys
input = sys.stdin.readline


def convert_to_base(n, base):
    digits = [i for i in range(100)]

    if n == 0:
        return [0]

    result = []
    while n > 0:
        result.append(digits[n%base])
        n //= base
    return result
    

for _ in range(int(input())):
    n = int(input())

    check = False

    for base in range(2,65):
        if check:
            break

        num = convert_to_base(n, base)
        i,j = 0, len(num)-1
        while i<j:
            if num[i] != num[j]:
                break
            i += 1
            j -= 1
        if j <= i:
            check = True
    
    print(1 if check else 0)
