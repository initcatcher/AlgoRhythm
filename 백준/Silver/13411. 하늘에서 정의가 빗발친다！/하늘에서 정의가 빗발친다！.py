import sys
input = sys.stdin.readline

N = int(input())
robots = []
for i in range(1,N+1):

    x,y,v = map(int,input().split())
    robots.append(((x*x + y*y)/(v*v), i))

robots.sort()

print(*map(lambda x: x[1], robots),sep='\n')
