package main

import (
	"sort"
	"fmt"
)

func solution(array []int, commands [][]int) []int {

	result := make([]int, len(commands))
	for idx, list := range commands {
		i := list[0] - 1
		j := list[1] - 1
		k := list[2] - 1

		portion := make([]int, j-i+1)
		copy(portion, array[i:j+1])
		sort.Sort(sort.IntSlice(portion))
		result[idx] = portion[k]
		fmt.Println(result)
	}
	return result
}

func main(){
	a := solution([]int{1,5,2,6,3,7,4}, [][]int{{2,5,3},{4,4,1}, {1,7,3}})
	fmt.Println(a)
}
