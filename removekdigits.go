// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if length of input is less than k return "0"
append first digit into stack
loop over string starting at 1

while k > 0  and stack not empty and inpNo[i]<last element of stack
pop element from stack and decrement k

then append inpNo[i] to stack

loop over stack and pop elements if k >0
remove all leading 0s from stack array

if length of stack is 0 return "0"
else return string(stack)
*/
package main

import "fmt"

func removeKdigits(inpNo string, k int) string {
	if len(inpNo) <= k {
		return "0"
	}

	var st []byte
	st = append(st, inpNo[0])

	for i := 1; i < len(inpNo); i++ {
		for ; k > 0 && len(st) > 0 && inpNo[i] < st[len(st)-1]; k-- {
			st = st[:len(st)-1]
		}

		st = append(st, inpNo[i])
	}
	for ; k > 0 && len(st) > 0; k-- {
		st = st[:len(st)-1]
	}

	// remove leading '0's if any
	for len(st) > 0 && st[0] == '0' {
		st = st[1:]
	}

	if len(st) == 0 {
		return "0"
	}

	return string(st)
}

func MainRemoveKDigits() {
	fmt.Println(removeKdigits("1432219", 3)) //expected 1219
}
