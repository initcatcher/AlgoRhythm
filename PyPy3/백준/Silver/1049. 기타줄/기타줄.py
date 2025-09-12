import sys
input = sys.stdin.readline

N, M = map(int,input().split())

package = []
each = []
for _ in range(M):
    a,b = map(int,input().split())
    package.append(a)
    each.append(b)

p_count = N // 6
e_count = N % 6

min_package = min(package)
min_each = min(each)

if min_each * 6 < min_package:
    print(N * min_each)
elif min_package < e_count*min_each:
    print(p_count*min_package + min_package)
else:
    print(p_count*min_package + e_count * min_each)
