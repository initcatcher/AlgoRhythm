import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n,m = map(int,input().split()) # 클라, 공급자수
    a = list(map(int,input().split())) # 받는거
    b = list(map(int,input().split())) # 보내는거
    day = list(input().strip())

    a.sort(reverse=True)
    b.sort()

    ans = 0
    account = 0
    idx_a, idx_b = 0,0
    for d in day:
        if d == '+':
            account += a[idx_a]
            idx_a += 1
        else:
            if account >= b[idx_b]:
                account -= b[idx_b]
                idx_b += 1
            else:
                ans += 1
    print(ans)
