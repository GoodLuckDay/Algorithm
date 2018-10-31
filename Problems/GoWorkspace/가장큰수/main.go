package main

/*
1. strconv패키지를 이용한 형변환
2. 재정의를 이용한 custom sort
*/

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
)

type customSort []string

func (s customSort) Len() int {
	return len(s)
}

func (s customSort) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s customSort) Less(i, j int) bool {

	if result := strings.Compare(s[i]+s[j], s[j]+s[i]); result == 1 {
		return true
	} else {
		return false
	}
}

func solution(numbers []int) string {

	obj := make([]string, len(numbers))

	for i, _ := range obj {
		obj[i] = strconv.Itoa(numbers[i])
	}

	sort.Sort(customSort(obj))
	result := strings.Join(obj, "")
	if obj[0] == "0" {
		temp, _ := strconv.Atoi(result)
		return strconv.Itoa(temp)
	} else {
		return result
	}
}

func main() {
	fmt.Println(solution([]int{3, 30, 34, 5, 9}))
	fmt.Println(solution([]int{21, 212}))
	fmt.Println(solution([]int{0, 0, 0, 0, 0}))
}
