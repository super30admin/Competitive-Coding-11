// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we use the approach of monotonic stack.
a)if the current element is greater than the top element on the stack,then we add it to the stack,else we pop the element from the stack till the current element is greater than or equal to the top element on the stack.for every pop that we do we decrement the k value by 1.
B)The value remaining in the stack is required result.


# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if k==0:
            return num
        if len(num)==1 and k==1:
            return '0'
        stack=[]
        stack.append(num[0])
        for i in range(1,len(num)):
            if num[i]>=stack[-1]:
                stack.append(num[i])
            else:
                while len(stack)!=0 and num[i]<stack[-1] and k>0:
                    stack.pop()
                    k=k-1
                stack.append(num[i])
        #checking for the k value .If it is not equal to 1 then we pop the elements till it becomes 1
        while k>0 and len(stack)>0:
            stack.pop()
            k=k-1
        #This condition is to check for trailing zeros
        if len(stack)==0 or ''.join(stack).lstrip('0')=='':
            return '0'
        else:
            return ''.join(stack).lstrip('0')
        
        