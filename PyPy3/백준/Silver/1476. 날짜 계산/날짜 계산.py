import sys
input = sys.stdin.readline

E,S,M = map(int,input().split())

E -= 1
S -= 1
M -= 1

x = 0
while True:
    if x % 15 == E and x % 28 == S and x % 19 == M:
        break
    x+=1
print(x+1)