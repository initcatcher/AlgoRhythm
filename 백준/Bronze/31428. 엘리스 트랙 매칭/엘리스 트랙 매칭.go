package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	
	// N 읽기 (사실 이 문제에서는 N을 사용하지 않아도 됨)
	scanner.Scan()
	
	// 친구들 트랙을 한 줄로 읽기
	scanner.Scan()
	friendsTracks := scanner.Text()
	
	// 헬로빗 트랙 읽기
	scanner.Scan()
	target := scanner.Text()

	fmt.Println(strings.Count(friendsTracks, target))

}