import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())

    div = 2
    count = 0
    while True:
        if n < div:
            break

        while n % div == 0:
            n //= div
            count += 1
        if count:
            print(div,count)
            count = 0
        div += 1