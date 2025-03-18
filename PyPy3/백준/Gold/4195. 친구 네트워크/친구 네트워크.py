from collections import defaultdict
import sys

input = sys.stdin.readline


def find(p):
    while pos[p] != p:
        p = pos[p]
    return p


for _ in range(int(input())):
    friend = defaultdict(int)
    idx = 1
    names = []
    pos = [-1]
    count = [-1]
    for _ in range(int(input())):
        a, b = input().split()

        if not friend[a]:
            friend[a] = idx
            idx += 1
            pos.append(len(pos))
            count.append(1)

        if not friend[b]:
            friend[b] = idx
            idx += 1
            pos.append(len(pos))
            count.append(1)

        # if a not in names:
        #     names.append(a)
        #     pos.append(len(pos))
        #     count.append(1)
        # if b not in names:
        #     names.append(b)
        #     pos.append(len(pos))
        #     count.append(1)

        # p1 = names.index(a)
        # p2 = names.index(b)

        p1 = find(friend[a])
        p2 = find(friend[b])
        # print(f"p1: {p1}, p2: {p2}")
        if p1 == p2:
            print(count[p1])
            continue

        l = min(p1, p2)
        r = max(p1, p2)
        pos[r] = l
        count[l] += count[r]

        print(count[l])
    # print(names)
    # print(pos)
    # print(count)
    # print()
