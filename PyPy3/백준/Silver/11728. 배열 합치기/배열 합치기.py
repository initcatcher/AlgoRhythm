import sys
input = sys.stdin.readline

_ = input()
a = list(map(int,input().split()))
b = list(map(int,input().split()))

print(*sorted(a+b))
