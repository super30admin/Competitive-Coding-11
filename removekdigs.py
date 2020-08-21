# check if all the elements of num should be removed, return "0"
# check every window of size k in nums, find the minimum value that lies in that window.
# reduce the window at every step. update the value of k = k-(minidx-initial_pos_of_window)
# Time complexity - O(kn)
# Space complexity - O(n-k)
# Did this solution run on leetcode? - yes
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        n = len(num) # length of num
        if k>=n: return "0"
        
        # result = ["0"]*
        result = ""
        i=0
        while k>0:
            minidx = i
            minval = num[i]
            for j in range(i, i+k+1):
                if minval > num[j]:
                    minval = num[j]
                    minidx = j
            result += num[minidx]
            k-= (minidx-i)
            i = minidx+1
            if n-i==k: break # if the last elements are to be removed, break from the loop
        
        if n-i!=k: 
            result += num[i:] 
        
        result = result.lstrip("0") # remove any leading zeros
        return result if result else "0"


# Using stacks
# Time complexity - O(n)
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
# Did you face any issues while running this? - Wasn't very intuitive to me.
from collections import deque
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        s = deque()
        i=0
        n = len(num)
        
        # insert the elements from num into the stack
        while i<n:
            # pop the topmost element if it is gtr. than the incoming num and k!=0
            while k>0 and s and num[i] < s[-1]: 
                s.pop()
                k-=1
            s.append(num[i])
            i+=1
        
        # pop the elements if extra elements from the end were pushed. (elements in increasing order)
        while k: 
            s.pop()
            k-=1
        
        result = ""
        i=0
        while s:
            result = s.pop() + result
        
        result = result.lstrip("0")
        return result if result else "0"