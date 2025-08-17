package main

import (
	"bufio"
	"fmt"
	"os"
)


func main(){
	in := bufio.NewReader(os.Stdin)

	var n,m int
	fmt.Fscan(in, &n, &m)
	coins := make([]int, n)

	for i:=0; i<n; i++ {
		fmt.Fscan(in, &coins[i])
	}

	// N=0이거나 M=0인 특수한 경우 처리
	if n == 0 {
		if m == 0 {
			fmt.Println(0)
		} else {
			fmt.Println(-1)
		}
		return
	}
	
	if m == 0 {
		fmt.Println(0)
		return
	}

	// 가장 최적화된 방법: 배열 + BFS
	const MAX_RANGE = 2001 // -1000 ~ 1000 (인덱스 0~2000)
	dist := make([]int, MAX_RANGE)
	for i := range dist {
		dist[i] = -1 // 미방문 표시
	}
	
	queue := make([]int, 0, MAX_RANGE)
	start := 1000 // 0을 인덱스 1000으로 매핑
	dist[start] = 0
	queue = append(queue, start)
	front := 0

	for front < len(queue) {
		current := queue[front]
		front++
		currentVal := current - 1000 // 실제 금액

		// 목표 금액에 도달했으면 결과 출력
		if currentVal == m {
			fmt.Println(dist[current])
			return
		}

		// 각 동전을 사용해 다음 상태로 이동
		for _, coin := range coins {
			nextVal := currentVal + coin
			next := nextVal + 1000 // 배열 인덱스로 변환
			
			// 범위 체크
			if next < 0 || next >= MAX_RANGE {
				continue
			}

			// 이미 방문했으면 스킵
			if dist[next] != -1 {
				continue
			}

			dist[next] = dist[current] + 1
			queue = append(queue, next)
		}
	}

	// 목표 금액에 도달할 수 없는 경우
	fmt.Println(-1)
}