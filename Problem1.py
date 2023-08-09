#TIme complexity is O(n)
#Space complexity is O(n)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        #Initializing the required variables
        stack=[]
        result=""
        #Iterating through the values in num
        for digit in num:
            #if the peek value ofthe stack is greater than the incoming digit, we will pop the stack
            while(stack and k>0 and stack[-1]>digit):
                stack.pop()
                k-=1
            #Finally we are appending the digit into the stack
            stack.append(digit)
        #If k is not 0, then will pop the stack
        for i in range(k):
            stack.pop()
        #Appending the values in stack to the result
        for h in stack:
            result+=h
        #Removing unnecessary 0's in the left side
        result=result.lstrip('0')
        #result="".join(stack).lstrip('0')
        #If the result is empty, we return "0"
        if(len(result)==0):
            return "0"
        #Else we will return result
        return result        