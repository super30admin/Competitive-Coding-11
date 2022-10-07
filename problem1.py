#reverse polish notation 
#time complexity:O(n)
#space: O(n)   
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        result=0
        operators=['+', '-', '*', '/']
        for i in tokens:
            if i in operators:
                second=stack.pop()
                first=stack.pop()
                if i=="+":
                    stack.append(int(first)+int(second))
                elif i=="-":
                    stack.append(int(first)-int(second))
                elif i=="*":
                    stack.append(int(first)*int(second))
                elif i=="/":
                    stack.append(int(first)/int(second))
            else:
                stack.append(int(i))
            
        result=stack.pop()
        return int(result)