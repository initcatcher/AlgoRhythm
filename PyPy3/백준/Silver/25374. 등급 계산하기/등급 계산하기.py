import sys
from collections import defaultdict
input = sys.stdin.readline
N = int(input())
students = list(map(int,input().split()))


rank = defaultdict(int)

for s in students:
    rank[s]+=1

kys = sorted(list(rank.keys()),reverse=True)
acc = 0

answer = [0] * 10
for grade in kys:
    if acc < 4:
        answer[1] += rank[grade]
    elif acc < 11:
        answer[2] += rank[grade]
    elif acc < 23:
        answer[3] += rank[grade]
    elif acc < 40:
        answer[4] += rank[grade]
    elif acc < 60:
        answer[5] += rank[grade]
    elif acc < 77:
        answer[6] += rank[grade]
    elif acc < 89:
        answer[7] += rank[grade]
    elif acc < 96:
        answer[8] += rank[grade]
    else:
        answer[9] += rank[grade]

    acc += rank[grade]

print('\n'.join(map(str,answer[1:])))