import sys
input = sys.stdin.readline

N,M = map(int, input().split())

books = []
for _ in range(M):
    day, page = map(int, input().split())
    books.append((day,page))

d = [0] * (N+1)

for day, page in books:
    for i in range(N, day -1, -1):
        d[i] = max(d[i-day]+page, d[i])

print(max(d))
