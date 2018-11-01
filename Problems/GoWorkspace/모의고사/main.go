package main

import (
	"fmt"
	"sort"
)

type studentInfo struct {
	studentN int
	count    int
}

type sortStudent []studentInfo

func (s sortStudent) Len() int {
	return len(s)
}

func (s sortStudent) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s sortStudent) Less(i, j int) bool {
	if s[i].count > s[j].count {
		return true
	} else if s[i].count < s[j].count {
		return false
	}
	return s[i].studentN < s[j].studentN
}

func solution(answers []int) []int {
	student1 := []int{1, 2, 3, 4, 5}
	student2 := []int{2, 1, 2, 3, 2, 4, 2, 5}
	student3 := []int{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}

	students := make([]studentInfo, 3)

	for i := 0; i < len(students); i++ {
		students[i] = studentInfo{i + 1, 0}
	}

	for idx, value := range answers {
		if value == student1[idx%len(student1)] {
			students[0].count += 1
		}
		if value == student2[idx%len(student2)] {
			students[1].count += 1

		}
		if value == student3[idx%len(student3)] {
			students[2].count += 1
		}
	}

	sort.Sort(sortStudent(students))
	maxValue := students[0].count
	count := 1

	for i := 1; i < len(students); i++ {
		if maxValue == students[i].count {
			count++
		}
	}

	result := make([]int, count)
	idx := 0
	for i := 0; i < len(students); i++ {
		if maxValue == students[i].count {
			result[idx] = students[i].studentN
			idx++
		}
	}

	return result
}

func main() {
	fmt.Println(solution([]int{1, 2, 3, 4, 5}))
	fmt.Println(solution([]int{1, 3, 2, 4, 2}))
}
