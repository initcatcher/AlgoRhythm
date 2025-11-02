from itertools import combinations
import sys
input = sys.stdin.readline


N = int(input())
S = list(map(int,input().split()))

S.sort()

sum_of_seq = set()
    
for j in range(1, N +1):
    for res in combinations(S, j):
        sum_of_seq.add(sum(res))


for i in range(1, sum(S)+2):
    if i not in sum_of_seq:
        print(i)
        break