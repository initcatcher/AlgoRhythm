import sys
input = sys.stdin.readline

N,M = map(int, input().split())

books = []
for _ in range(M):
    day, page = map(int, input().split())
    books.append((day,page))

d = [0] * (N+1)

for day, page in books:
    for i in range(N, -1, -1):
        if d[i] and i+day <= N:
            d[i+day] = max(d[i]+page, d[i+day])
    if day <= N:
        d[day] = max(page, d[day])
print(max(d))
