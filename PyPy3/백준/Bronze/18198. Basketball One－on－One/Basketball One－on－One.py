import sys
input = sys.stdin.readline

str = input().strip()
a,b = 0,0
for i in range(0,len(str),2):
    person, score = str[i], int(str[i+1])
    if person == 'A':
        a += score
    else:
        b += score
print('A' if a > b else 'B')