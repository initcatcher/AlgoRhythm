from collections import defaultdict
import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())
grid = [list(input().strip()) for _ in range(N)]
max_length = 5
precomp = defaultdict(int)

# 8방향 (상하좌우 및 대각선)
directions = [
    (0, 1), (-1, 1), (-1, 0), (-1, -1),
    (0, -1), (1, -1), (1, 0), (1, 1)
]

def dfs(y, x, cur_string):
    precomp[cur_string] += 1
    if len(cur_string) == max_length:
        return
    for dy, dx in directions:
        ny, nx = y + dy, x + dx
        # 환형 조건: 행과 열을 wrap-around
        if ny < 0:
            ny = N - 1
        elif ny >= N:
            ny = 0
        if nx < 0:
            nx = M - 1
        elif nx >= M:
            nx = 0
        dfs(ny, nx, cur_string + grid[ny][nx])

# 모든 시작점에 대해 DFS 수행하여 가능한 문자열과 경우의 수 미리 계산
for y in range(N):
    for x in range(M):
        dfs(y, x, grid[y][x])

# 쿼리마다 딕셔너리에서 결과 출력
for _ in range(K):
    query = input().strip()
    print(precomp[query])
