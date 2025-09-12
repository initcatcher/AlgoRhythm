import sys
input = sys.stdin.readline

N, M = map(int,input().split())

arr = [input().strip() for _ in range(N)]

tmp = 0
for y in range(N):
    for x in range(M):
        size = tmp
        while x+size <M and y+size<N:
            s = set()
            s.add(arr[y][x])
            s.add(arr[y][x+size])
            s.add(arr[y+size][x])
            s.add(arr[y+size][x+size])
            if len(s) == 1:
                tmp = size
            size+=1
side = tmp+1
print(side*side)