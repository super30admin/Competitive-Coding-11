#Append to stack until we encounter a situation wheere current number is less than top eleement in stack, if condition is satisfied, then pop the element, continue with process until k becomes 0
#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if num is None or len(num) == 0:
            return ""
        ll = list()
        ll.append(num[0])
        for i in range(1,len(num)):
            while ll and ll[-1] > num[i] and k>0:
                ll.pop()
                k = k - 1
            ll.append(num[i])
        
        for i in range(k):
            ll.pop()
        st = "".join(ll).lstrip("0")
        return st