#Time Complexity : O(N)
#Space Complexity : O(N)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        result = 0
        for i in tokens:
            if(i=="+" or i=="-" or i=="*" or i=="/"):
                a,b=stack.pop(),stack.pop()
            if(i=="+"):
                result = a+b
                stack.append(result)
            elif(i=="-"):
                result = b-a
                stack.append(result)
            elif(i=="*"):
                result = a*b
                stack.append(result)
            elif(i=="/"):
                result = int(b/a)
                stack.append(result)
            else:
                stack.append(int(i))
        return stack[0]

        