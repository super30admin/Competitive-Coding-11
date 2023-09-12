class Solution:
    def evalRPN(self, tokens: List[str]) -> int:


        #Stack - TC and SC - O(n)
        #Keep adding nums to stack, the moment you see a expression, pop the top 2 elements, do the operation and put the result back in.
        n = len(tokens)

        stack = []
        exp= ['+', '-', '*', '/']

        for i in range(n):
            cur = tokens[i]

            if cur not in exp:
                stack.append(int(cur))

            else:
                    a = int(stack.pop())
                    b = int(stack.pop())

                    if cur == '+':
                        stack.append(a+b)
                    elif cur == '-':
                        stack.append(b - a)
                    elif cur == '*':
                        stack.append(a*b)
                    elif cur == '/':
                        stack.append(int(b/a))
        return stack[0]