import sys
input = sys.stdin.readline

N, L = map(int,input().split())

while True:
    if L > 100:
        print(-1)
        break

    x = (N - (L-1)*L/2)/ L
    if int(x) == x and x >= 0:
        print(*[i+int(x) for i in range(L)])
        break
    L += 1
