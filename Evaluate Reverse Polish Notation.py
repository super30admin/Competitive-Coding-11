# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = list()
        s = {'+', '-', '*', '/'}
        for i in tokens:
            if(i not in s and not i.isalpha()):
                stack.append(int(i))
            else:
                b = stack.pop()
                a = stack.pop()
                if(i == '/'):
                    c = a//b
                    if(c < 0 and a % b != 0):
                        c += 1
                elif(i == '+'):
                    c = a + b
                elif(i == '-'):
                    c = a - b
                else:
                    c = a * b
                stack.append(c)
        return stack.pop()
                    
                    
        
        