import sys
input = sys.stdin.readline

r,c,zr,zc = map(int,input().split())

m = [list(input().strip()) for _ in range(r)]

ans = ''

for i in range(r):
    row = ''.join(map(lambda x: zc*x, m[i])) + '\n'
    row *= zr
    ans += row
print(ans)