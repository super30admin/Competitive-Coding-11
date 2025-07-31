"""
Use a stack to build the smallest number by greedily removing digits from left to right
While the current digit is less than the top of the stack, pop from the stack (i.e., remove larger digits before a smaller one)
After the loop, remove any remaining digits from the end if k > 0, and strip leading zeros
"""
"""
Time Complexity: O(n - One pass through digits
Space Complexity: O(n) - Stack to hold digits
"""

class removeKdigits:
    def removeKdigit(self, num: str, k: int) -> str:
        stack = []

        for digit in num:
            while k > 0 and stack and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)

        while k > 0:
            stack.pop()
            k -= 1

        result = ''.join(stack).lstrip('0')
        return result if result else "0"

if __name__ == "__main__":
    obj = removeKdigits()
    print(obj.removeKdigit("1432219", 3)) 
    print(obj.removeKdigit("10200", 1)) 
    print(obj.removeKdigit("10", 2))
    print(obj.removeKdigit("1234567890", 9)) 
