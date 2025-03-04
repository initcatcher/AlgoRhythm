R,C,K = map(int,input().split())
answer = 0

road = [list(input()) for _ in range(R)]
check = [[False]*C for _ in range(R)]

for i in range(R):
    for j in range(C):
        if road[i][j] == 'T':
            check[i][j] = True
check[R-1][0]=True

def solve(y,x,count):
    # print(y,x, end=' ')
    global R,C,K,answer
    if count > K:
        # print()
        return
    
    if y == 0 and x == C-1:
        if count == K:
            answer += 1
        return
    
    for dy,dx in [(0,1),(-1,0), (0,-1),(1,0)]:
        next_y = y + dy
        next_x = x + dx
        if 0<=next_y<R and 0<=next_x<C and not check[next_y][next_x]:
            check[next_y][next_x]=True
            solve(next_y,next_x,count+1)
            check[next_y][next_x]=False

solve(R-1,0,1)
print(answer)