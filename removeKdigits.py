class Solution:
    
    """
    Description: remove k digits from the number in form of a string so that the new number is the smallest possible
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Approach: Using stack:
    - start with an stack and append it unless the values are smaller than the current element
    - if current element is smaller than top number on the stack, then drop that number and reduce value of k by 1
    - in case after visiting each element the length of the stack is larger than required; pop elements until k becomes 0
    - to take care of leading 0 (example #2), convert the stack to int and reconvert back to string
    """
    
    def removeKdigits(self, num: str, k: int) -> str:
        
        if num == None: return 
        if k == 0: return num
        if len(num) == k: return "0"
        
        stack = [];

        for d in num:
            while stack and stack[-1] > d and k:
                stack.pop()
                k -= 1
            stack.append(d)

        while k != 0:
            stack.pop()
            k -= 1
        
        return str(int("".join([str(elem) for elem in stack])))
                
