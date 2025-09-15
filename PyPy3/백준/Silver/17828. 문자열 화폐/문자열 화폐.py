import sys
input = sys.stdin.readline

N, X = map(int, input().split())

# 1) 애초에 불가능한 합이면 바로 '!'
if X < N or X > 26 * N:
    print('!')
    sys.exit()

# 2) 뒤에 붙일 Z의 개수: k ≤ N 이고 k ≤ (X - N) // 25
z = min(N, (X - N) // 25)

# 3) 앞부분 길이와 남은 합
m = N - z                 # 앞부분 길이
rem = X - 26 * z          # 앞부분이 만들어야 할 합

# 4) 사전순 최소: 앞부분은 'A'*(m-1) + 한 글자
#    이 한 글자의 값 t = rem - (m-1), 항상 1..26 범위가 되도록 위에서 z를 잡았음
if m == 0:                # 전부 Z인 경우 (X = 26N)
    print('Z' * z)
else:
    t = rem - (m - 1)
    print('A' * (m - 1) + chr(ord('A') + t - 1) + 'Z' * z)
