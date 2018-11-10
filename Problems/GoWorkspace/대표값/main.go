package main

/*
2592번 대표값 문
*/
import "fmt"

func main() {
	array := make([]int, 100)
	sum := 0

	for i := 0; i < 10; i++ {
		inputNum := 0
		fmt.Scan(&inputNum)

		sum += inputNum
		array[inputNum/10] += 1
	}
	freq_index := 0

	for i := 1; i < 100; i++ {
		if array[freq_index] < array[i] {
			freq_index = i
		}
	}

	fmt.Printf("%d\n%d", sum/10, freq_index*10)

}
