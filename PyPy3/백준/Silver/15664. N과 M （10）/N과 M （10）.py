import sys
from itertools import combinations

input = sys.stdin.readline

N, M = map(int, input().split())
nums = sorted(map(int, input().split()))  # 입력을 먼저 정렬

seen = set()
for comb in combinations(nums, M):        # 조합은 이미 비내림차순
    seen.add(tuple(comb))                 # 문자열 말고 숫자 튜플로 저장

for seq in sorted(seen):                  # 숫자 튜플 기준으로 정렬 => 올바른 사전순
    print(*seq)
