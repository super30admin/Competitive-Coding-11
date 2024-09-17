'''
Time Complexity: 0(n)
Space Complexity: 0(n) -- stack
Run On LeetCode: Yes
'''
class Solution:
    
    def __init__(self):
        self.__stack = []
    
    def evalRPN(self, tokens: List[str]) -> int:
        for t in tokens:
            if t == '+':
                pop1 = self.__stack.pop()
                pop2 = self.__stack.pop()
                self.__stack.append(pop2+pop1)
            elif t == '-':
                pop1 = self.__stack.pop()
                pop2 = self.__stack.pop()
                self.__stack.append(pop2-pop1)
            elif t == '*':
                pop1 = self.__stack.pop()
                pop2 = self.__stack.pop()
                self.__stack.append(pop2*pop1)
            elif t == '/':
                pop1 = self.__stack.pop()
                pop2 = self.__stack.pop()
                self.__stack.append(int(pop2/pop1))
            else:
                self.__stack.append(int(t))
        '''end of iteration'''
        return self.__stack[-1]
            