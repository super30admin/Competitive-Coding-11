class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        """
         ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        stack = [22 ]
        13/5
        """
        stack = deque()

        for token in tokens:
            if token == "+":
                n1, n2 = stack.pop(), stack.pop()
                stack.append(n1+n2)
            elif token == "-":
                n1, n2 = stack.pop(), stack.pop()
                stack.append(n2-n1)
            elif token == "*":
                n1, n2 = stack.pop(), stack.pop()
                stack.append(n1*n2)
            elif token == "/":
                n1, n2 = stack.pop(), stack.pop()
                stack.append(int(n2/n1))
            
            else:
                stack.append(int(token))

            # print(stack)
    
        return stack.pop()
