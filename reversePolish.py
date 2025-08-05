class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        for char in tokens:
            if char.lstrip("-").isdigit():
                stack.append(int(char))
                
            else:
                second=stack.pop()
                first=stack.pop()
                if char=="+":
                    stack.append(first+second)
                if char=="-":
                    stack.append(first-second)
                if char=="*":
                    stack.append(first*second)
                if char=="/":
                    stack.append(int(first/second))
                
            
            
        
        return stack[0]
