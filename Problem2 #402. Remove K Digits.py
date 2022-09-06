# Time Complexity: O(N)     # N is number of elements in the num list
# Space Complexity: O(N)    # stack height

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        # base
        if str is None:
            return "0"
        
        # logic
        monoStack = []
        for i in num:
            while k > 0 and monoStack and monoStack[-1] > i:
                k = k - 1
                monoStack.pop()
            monoStack.append(i)
        
        monoStack = monoStack[:len(monoStack) - k]
        result = "".join(monoStack)
        
        if result:
            return str(int(result))
        else:
            return "0"
