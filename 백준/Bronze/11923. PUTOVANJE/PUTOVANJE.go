package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	in := bufio.NewReader(os.Stdin)

	var n, c int
	fmt.Fscan(in, &n, &c)

	w := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(in, &w[i])
	}

	maxCount := 0
	for i := 0; i < n; i++ {
		sum, count := 0, 0
		for j := i; j < n; j++ {
			if sum+w[j] <= c {
				sum += w[j]
				count++
			}
		}
		if count > maxCount {
			maxCount = count
		}
		if maxCount == n-i {
			break
		}
	}

	fmt.Println(maxCount)
}
