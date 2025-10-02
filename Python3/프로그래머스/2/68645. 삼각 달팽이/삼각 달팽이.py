def solution(n):
    pyramid = [[0] * i for i in range(n+1)]
    d = [(1,0),(0,1),(-1,-1)]
    idx = 0
    step = n
    y,x = 0,0
    num = 0
    while step > 0:
        dy,dx = d[idx]
        for _ in range(step):
            y += dy
            x += dx
            num += 1
            pyramid[y][x] = num
        
        idx = (idx+1)%3
        step -= 1
    answer = []
    for row in pyramid:
        answer += row
    return answer
    
