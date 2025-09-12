from collections import deque
import sys
input = sys.stdin.readline

for _ in range(int(input())):
    M, N, K = map(int, input().split())

    grid = [[0] * M for _ in range(N)]
    check = [[False] * M for _ in range(N)]

    for _ in range(K):
        x, y = map(int, input().split())
        grid[y][x] = 1
    
    ans = 0
    for y in range(N):
        for x in range(M):
            if not check[y][x] and grid[y][x] == 1:
                ans += 1
                dq = deque()
                dq.append((y, x))
                check[y][x] = True
                
                while dq:
                    cy, cx = dq.popleft()  # 변수명 변경으로 혼동 방지
                    
                    for dy, dx in [[0,1], [-1,0], [0,-1], [1,0]]:
                        next_x, next_y = cx + dx, cy + dy
                        if 0 <= next_x < M and 0 <= next_y < N and not check[next_y][next_x]:
                            if grid[next_y][next_x]:
                                check[next_y][next_x] = True
                                dq.append((next_y, next_x))
                
                # 디버깅 출력 제거!
    
    print(ans)  # 오직 이것만 출력