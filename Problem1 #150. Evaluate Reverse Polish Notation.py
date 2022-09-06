# Time Complexity: O(N)     # N is number of elements in the tokens list
# Space Complexity: O(N)    # stack height

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # base 
        if tokens is None:
            return None
        
        # logic
        digitStack = []
        result = 0
        
        for i in range(len(tokens)):
            if tokens[i] not in ["+","-","/","*"]:
                digitStack.append(tokens[i])
            else:
                num2 = digitStack.pop()
                num1 = digitStack.pop()
                
                if tokens[i] == "+":
                    result = int(num1) + int(num2)
                elif tokens[i] == "-":
                    result = int(num1) - int(num2)
                elif tokens[i] == "*":
                    result = int(num1) * int(num2)
                else:
                    result = int(num1) / int(num2)
                    if result < 0:
                        result = math.ceil(result)
                    else:
                        result = math.floor(result)
                
                digitStack.append(result)
                
        return digitStack[0]