"""
Leetcode: https://leetcode.com/problems/evaluate-reverse-polish-notation/

Approach: Evaluate with Stack

Time Complexity : O(n), n is the length of the list. We do a linear search to put all numbers on the stack, and
process all operators. Processing an operator requires removing 2 numbers off the stack and replacing them with a
single number, which is an O(1)O(1) operation. Therefore, the total cost is proportional to the length of the
input array.

Space Complexity : O(n)
"""


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        operations = {
        "+": lambda a, b: a + b,
        "-": lambda a, b: a - b,
        "/": lambda a, b: int(a / b),
        "*": lambda a, b: a * b
        }

        stack = []
        for token in tokens:
            if token in operations:
                number_2 = stack.pop()
                number_1 = stack.pop()
                operation = operations[token]
                stack.append(operation(number_1, number_2))
            else:
                stack.append(int(token))
        return stack.pop()

