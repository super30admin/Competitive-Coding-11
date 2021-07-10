"""
150. Evaluate Reverse Polish Notation
TC - O(n)
SC - O(n)
"""
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if len(tokens)==0 or tokens == None:
            return 0
        stack = []
        operators = ["+","-","*","/"]
        
        for ele in tokens:
            if ele in operators:
                num2 = int(stack.pop())
                num1 = int(stack.pop())
                
                if ele == "+":
                    stack.append(num1+num2)
                elif ele == "-":
                    stack.append(num1-num2)
                elif ele == "*":
                    stack.append(num1*num2)
                else:
                    stack.append(int(num1/num2))
            else:
                stack.append(ele)
        return stack.pop()
            
                    