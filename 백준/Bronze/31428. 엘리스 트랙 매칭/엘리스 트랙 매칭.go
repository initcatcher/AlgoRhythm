package main

import "fmt"

func main() {

   var N int
   fmt.Scanf("%d", &N)
   m := make(map[string]int)

   for i:=0; i<N; i++ {
      var key string
      fmt.Scanf("%s", &key)
      m[key]++
   }
   var target string
   fmt.Scanf("%s", &target)
   fmt.Println(m[target])
}