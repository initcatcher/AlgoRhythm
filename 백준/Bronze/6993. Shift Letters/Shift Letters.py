import sys
input = sys.stdin.readline


for _ in range(int(input())):
    word, pos = input().split()
    pos = int(pos)

    print(f'Shifting {word} by {pos} positions gives us: {word[-pos:]+word[:-pos]}')