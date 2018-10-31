package main

/*
math 라이브러리에 있는 Min, Max 메소드를 사용할려 했지만 매개변수가 float형
*/

import (
	"fmt"
	"sort"
)

func Min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func Max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func solution(citations []int) int {
	sort.Sort(sort.Reverse(sort.IntSlice(citations)))
	result := 0
	for i, value := range citations {
		temp := Min(value, i+1)
		result = Max(result, temp)
	}
	return result
}

func main() {
	fmt.Println(solution([]int{3, 0, 6, 1, 5}))
	//fmt.Println(solution([]int{0,15,4,0,7,10,0}))
}
