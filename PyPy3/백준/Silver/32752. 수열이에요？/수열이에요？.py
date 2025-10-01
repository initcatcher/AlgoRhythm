import sys
input = sys.stdin.readline

N,L,R = map(int,input().split())
L-=1
arr = list(map(int,input().split()))


arr = arr[:L] + sorted(arr[L:R]) + arr[R:]

for i in range(0, len(arr)-1):
    if arr[i] > arr[i+1]:
        print(0)
        exit(0)
print(1)