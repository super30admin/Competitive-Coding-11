// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if we encounter a number then put it in stack
if we encounter a symbol then pop 2 elements convert and do opertaion on them and push the result into stack again
return last element from stack
*/
package main

import (
	"fmt"
	"strconv"
)

func evalRPN(tokens []string) int {
	st := []string{}
	for i := 0; i < len(tokens); i++ {
		if tokens[i] == "+" {
			num2, _ := strconv.Atoi(st[len(st)-1])
			st = st[:len(st)-1]
			num1, _ := strconv.Atoi(st[len(st)-1])
			st = st[:len(st)-1]
			st = append(st, strconv.Itoa(num1+num2))
		} else if tokens[i] == "-" {
			num2, _ := strconv.Atoi(st[len(st)-1])
			st = st[:len(st)-1]
			num1, _ := strconv.Atoi(st[len(st)-1])
			st = st[:len(st)-1]
			st = append(st, strconv.Itoa(num1-num2))
		} else if tokens[i] == "*" {
			num2, _ := strconv.Atoi(st[len(st)-1])
			st = st[:len(st)-1]
			num1, _ := strconv.Atoi(st[len(st)-1])
			st = st[:len(st)-1]
			st = append(st, strconv.Itoa(num1*num2))
		} else if tokens[i] == "/" {
			num2, _ := strconv.Atoi(st[len(st)-1])
			st = st[:len(st)-1]
			num1, _ := strconv.Atoi(st[len(st)-1])
			st = st[:len(st)-1]
			st = append(st, strconv.Itoa(num1/num2))
		} else {
			st = append(st, tokens[i])
		}
	}
	res, _ := strconv.Atoi(st[0])
	return res
}

func MainEvalRPN() {
	fmt.Println(evalRPN([]string{"2", "1", "+", "3", "*"})) //expected 9
}
