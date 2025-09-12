from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int,input().split()))
P = [0] * N

idx = 0
for i in range(1,1001):
    for j, num in enumerate(A):
        if i == num:
            P[j] = idx
            idx+=1
print(*P)