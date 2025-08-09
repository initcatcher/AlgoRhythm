package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	in := bufio.NewReader(os.Stdin)
	out := bufio.NewWriter(os.Stdout)
	defer out.Flush()

	var n int
	fmt.Fscan(in, &n)
	for i := 0; i < n; i++ {
		var x, y int
		fmt.Fscan(in, &x, &y)

		if x == y {
			if x%2 == 0 {
				fmt.Fprintln(out, x*2)
			} else {
				fmt.Fprintln(out, x*2-1)
			}
		} else if x == y+2 {
			if x%2 == 0 {
				fmt.Fprintln(out, x*2-2)
			} else {
				fmt.Fprintln(out, x*2-3)
			}
		} else {
			fmt.Fprintln(out, "No Number")
		}
	}
}
