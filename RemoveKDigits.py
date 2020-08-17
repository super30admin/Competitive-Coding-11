class Solution:
    
    """
    
            Name : Shahreen Shahjahan Psyche
            Language Used : Python
            Time : O(N)
            Space: O(N)
            Passed All The Test Cases in LC : Yes
            
            Approach : # Data Structure : Stack
                       # Its a greedy approach
                       # initialize the stack
                       # if stack is not empty and k is valid then keep popping until a smaller value is encountered from stack
                       # append the current value
                       # after iterating through the number, if k is still valid then we are skipping the first k digits or we are returning the remaining values
                         from stack after joining them
                        
                       
    
    """
    def removeKdigits(self, num: str, k: int) -> str:
        
        if len(num) <= k:
            return "0"
        # edgee case
        if not num or k == 0:
            return num
        
        track = []
        
        for i in range(len(num)):
            val = int(num[i])
            while len(track) != 0 and val < track[-1] and k:
                k -= 1
                track.pop()
            track.append(val)
            
        
        if k != 0:
            track = track[:-k]
        res = 0 
        for i in track:
            res  = res*10 + i
        
        return str(res)
        
