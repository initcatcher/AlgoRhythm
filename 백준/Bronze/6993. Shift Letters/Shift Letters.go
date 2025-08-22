package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	// 첫 줄: 테스트 케이스 개수
	line, _ := reader.ReadString('\n')
	t, _ := strconv.Atoi(strings.TrimSpace(line))

	for i := 0; i < t; i++ {
		// 단어와 숫자 입력 받기
		line, _ := reader.ReadString('\n')
		parts := strings.Fields(line)
		word := parts[0]
		pos, _ := strconv.Atoi(parts[1])

		// 회전 (pos 만큼 뒤에서 잘라 앞에 붙이기)
		n := len(word)
		pos = pos % n // word 길이보다 큰 값 방지
		shifted := word[n-pos:] + word[:n-pos]

		fmt.Printf("Shifting %s by %d positions gives us: %s\n", word, pos, shifted)
	}
}
