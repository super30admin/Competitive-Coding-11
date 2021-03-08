# Approach - Process only when we hit an operator, keep pushing digits to stack, and pop when we encounter operator and push processed result
# Time - O(N)
# Space - O(N)


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        
        if not tokens or len(tokens) == 0:
            return 0
        
        st = []
        
        operators = ['+', '-', '*', '/']

        for t in tokens:
            if t not in operators:
                st.append(t)
                
            else:
                # operator
    
                num1 = int(st.pop())
                num2 = int(st.pop())
                
                if t == "+":
                    result = num2 + num1
                    
                    
                elif t == "-":
                    result = num2 - num1
                    
                    
                elif t == "*":
                    result = num2 * num1
                    
                    
                else: #division
                    result = int(num2 / num1)
                    
                st.append(result)
                    
                    
        return st[-1]