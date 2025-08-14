package main

import "fmt"

func main(){
	var weight, height float64
	fmt.Scan(&weight)
	fmt.Scan(&height)

	 bmi := weight / (height * height)

	 if bmi < 18.5 {
		 fmt.Println("Underweight")
	 } else if bmi <= 25.0 {
		 fmt.Println("Normal weight")
	 } else {
		 fmt.Println("Overweight")
	 }
}