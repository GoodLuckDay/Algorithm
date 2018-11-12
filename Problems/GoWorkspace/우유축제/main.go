package main

import "fmt"

func main() {
	var N int
	fmt.Scanf("%d", &N)

	array := make([]int, N)
	cache := make([][]int, N)
	for i := 0; i < N; i++ {
		fmt.Scanf("%d", &array[i])
		cache[i] = make([]int, 3)
	}

	cache[N-1][array[N-1]] = 1

	for i := N - 2; i >= 0; i-- {
		for j := 0; j < 3; j++ {
			if array[i] == j {
				cache[i][j] = 1 + cache[i+1][(j+1)%3]
			} else {
				cache[i][j] = cache[i+1][j]
			}
		}
	}

	fmt.Println(cache[0][0])

}
