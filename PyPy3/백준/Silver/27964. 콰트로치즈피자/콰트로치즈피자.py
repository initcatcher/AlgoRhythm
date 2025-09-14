import sys
input = sys.stdin.readline

N = int(input())
arr = set(input().split())

count = 0
for el in arr:
    if el.endswith('Cheese'):
        count += 1
print('yummy' if count >= 4 else 'sad')