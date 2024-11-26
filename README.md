# Competitive-Coding-11

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 


## Problem 1 - https://leetcode.com/problems/remove-k-digits/description/

The function removeKdigits removes k digits from the string num to form the smallest possible number. It uses a stack-based greedy approach to achieve this. The algorithm iterates through each character in num, and for each character, it pops elements from the stack if the current character is smaller than the top of the stack and k > 0. This ensures that larger digits are removed to allow smaller digits to remain, leading to a smaller overall number. After the traversal, any remaining k digits are removed by popping from the stack. The stack elements are then reversed to get the correct order of digits. Finally, leading zeros are removed by finding the first non-zero character. If the result is empty, "0" is returned.



## Problem 2 - https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

The evalRPN function evaluates a Reverse Polish Notation (RPN) expression represented by the input array tokens. It uses a stack to store intermediate results during the evaluation. As the algorithm iterates through tokens, it checks if the current token is an operator (+, -, *, or /). If it is, the top two numbers are popped from the stack, the operation is performed, and the result is pushed back onto the stack. If the token is a number, it is directly pushed onto the stack. At the end of the iteration, the final result of the RPN expression is the only value left in the stack, which is returned.


