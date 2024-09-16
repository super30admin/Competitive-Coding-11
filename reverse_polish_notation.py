"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
We use stack here to keep track of the latest operands that come before
the operator and at the time of processing the operator, we pop the last two
operands the perform the respective operation and put updated value to stack
return stack's top element in the end
"""
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        # Valid operators are +, -, *, /. Each operand may be an integer or another expression.

        # Input: ["2", "1", "+", "3", "*"]
        # Output: 9
        # Explanation: ((2 + 1) * 3) = 9
        #test

        # Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
        # Output: 22
        #   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        # = ((10 * (6 / (12 * -11))) + 17) + 5
        # = ((10 * (6 / -132)) + 17) + 5
        # = ((10 * 0) + 17) + 5
        # = (0 + 17) + 5
        # = 17 + 5
        # = 22
        stk = [] #mention why stk
        operator_set = set(["*","/","+","-"]) #mention why set
        for obj in tokens:
            if obj not in operator_set:
                #appending the operand to the stack
                stk.append(int(obj))
            else:
                #if len(stk)
                op2 = stk.pop()
                op1 = stk.pop()
                if obj == '*':
                    stk.append(op1 * op2)
                if obj == '/':
                    stk.append(int(op1 / op2)) #handling the negative sign in division, since python3 rounds to ceil(6 /132-> 0.04545)
                if obj == '+':
                    stk.append(op1 + op2)
                if obj == '-':
                    stk.append(op1 - op2)
        return stk.pop()