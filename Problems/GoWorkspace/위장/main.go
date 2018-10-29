package main

import "fmt"

func solution(clothes [][]string) int {
	idMap := make(map[string]int)
	result := 1
	for i:=0; i< len(clothes); i++{
		_, exist := idMap[clothes[i][1]]
		if !exist{
			idMap[clothes[i][1]] = 1
		} else{
			idMap[clothes[i][1]] += 1
		}
	}

	for _, value := range idMap{
		result *= (value+1)
	}

	return result-1
}

func main(){
	fmt.Print(solution([][]string{{"yellow_hat", "headgear"},{"blue_sunglasses", "face"},{"smoky_makeup", "face"}}))
}
