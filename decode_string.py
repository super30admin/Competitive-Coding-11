# Time -> O(n)
#Space -> O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        stack=[]
        
        #As discussed I am iterating through the loop
        for i in range(len(s)):
            #Adding the elements until we reach the ] bracket 
            if s[i]!="]":
                stack.append(s[i])
            
            #now when we reach the bracket then we pop the lements until we reach [
            else:
                substr=""
                while stack[-1]!="[":
                    substr=stack.pop()+substr
                
                #popping the [ bracket
                stack.pop()
                
                #If we encounter a digit then we add it to the front of k
                k=""
                while stack and stack[-1].isdigit():
                    k=stack.pop()+k
                
                #We are adding our whole result to the stack
                stack.append(int(k)*substr)
        
        #At the end we are joining the result i.e the characters of the stack
        return "".join(stack)