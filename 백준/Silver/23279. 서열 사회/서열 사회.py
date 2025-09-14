import sys
input = sys.stdin.readline

N, K = map(int, input().split())

group = [[] for _ in range(K)]
for i in range(K):
    group[i] = list(map(int,input().split()))[1:]
    group[i].sort()


answer = [[] for _ in range(K)]
count = 1

while count <= N:
    check = False
    for i in range(K):
        if len(group[i])>0 and group[i][0] == 0:
            tmp = 0
            while len(group[i])>0 and group[i][0] == 0:
                answer[i].append(count)
                count += 1
                tmp +=1
                group[i].pop(0)
            
            for j in range(K):
                for idx in range(len(group[j])):
                    if i != j:
                        group[j][idx] -= tmp
            check = True
            break
    if not check:
        for i in range(K):
            for j in range(len(group[i])):
                group[i][j] -= 1

for group in answer:
    print(*group)
