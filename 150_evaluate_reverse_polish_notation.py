from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        """
            https://leetcode.com/problems/evaluate-reverse-polish-notation/
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the length of tokens list.
        """
        stack = []
        for token in tokens:
            if token in {'+', '-', '*', '/'}:
                num1 = stack.pop()
                num2 = stack.pop()
                cur = 0
                if token == '+':
                    cur = num2 + num1
                elif token == '-':
                    cur = num2 - num1
                elif token == '*':
                    cur = num2 * num1
                elif token == '/':
                    cur = int(float(num2 / num1))
                stack.append(cur)
            else:
                stack.append(int(token))
        return stack.pop()


if __name__ == '__main__':
    Solution().evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"])
