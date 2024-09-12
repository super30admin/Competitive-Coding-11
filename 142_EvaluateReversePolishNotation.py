'''
Accepted on leetcode(150)
time - O(N)
space -O(N)
Approach:
1. use a hashset to store operators
2. use a stack to store integer values.
3. Iterate over the given list if we encounter an operator then pop last 2 items in stack and perform the operation and add the result back to stack.
4. Finally return the last element in stack.

'''
class Solution:
    def evalRPN(self, tokens) -> int:
        stack = []
        hashset = {"+","-","*","/"}
        for s in tokens:
            if s in hashset:
                first = stack.pop()
                second = stack.pop()
                if s == '+':
                    stack.append(second+first)
                elif s == '-':
                    stack.append(second-first)
                elif s == '*':
                    stack.append(second*first)
                elif s == '/':
                    stack.append(int(second/first))
            else:
                stack.append(int(s))
        return stack.pop()