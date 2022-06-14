#Remove k digits

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if(len(num)==0): return "0"
        stack=[num[0]]
        for i in range(1, len(num)):                            #find the highest leading numbers and remove them until k gets to 0
            while(stack and k!=0 and stack[-1] > num[i]):       #if the current element is less than the top element on the stack, then pop it 
                stack.pop()
                k-=1
            stack.append(num[i])

        stack=stack[:len(stack)-k]                          #if k is still not 0, then remove the last k elements
        s=""
        for i in stack:                                     #change it to string
            s+=i
        
        s=s.lstrip("0")                                     #take off the leading 0s
        
        if len(s)==0:                                       #if its empty return 0 or return the string
            return "0"
        else:
            return s
        