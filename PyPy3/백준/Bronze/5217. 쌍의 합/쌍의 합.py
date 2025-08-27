import sys
input = sys.stdin.readline

for _ in range(int(input())):
    p = int(input())
    
    x,y=1,p-1
    ans = []
    while x<y:
        ans.append(f'{x} {y}')
        x+=1
        y-=1
    ans = ', '.join(ans)
    print(f'Pairs for {p}: {ans}')
