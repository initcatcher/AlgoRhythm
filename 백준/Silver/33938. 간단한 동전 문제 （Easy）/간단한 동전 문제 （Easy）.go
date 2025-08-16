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

	// BFS를 위한 큐와 방문 체크용 맵
	queue := []int{0}
	visited := make(map[int]int) // 금액 -> 최소 동전 개수
	visited[0] = 0

	for len(queue) > 0 {
		current := queue[0]
		queue = queue[1:]

		// 목표 금액에 도달했으면 결과 출력
		if current == m {
			fmt.Println(visited[m])
			return
		}

		// 각 동전을 사용해 다음 상태로 이동
		for _, coin := range coins {
			next := current + coin
			
			// 범위 체크 (-1000 ~ 1000)
			if next < -1000 || next > 1000 {
				continue
			}

			// 이미 방문했으면 스킵
			if _, exists := visited[next]; exists {
				continue
			}

			visited[next] = visited[current] + 1
			queue = append(queue, next)
		}
	}

	// 목표 금액에 도달할 수 없는 경우
	fmt.Println(-1)
}