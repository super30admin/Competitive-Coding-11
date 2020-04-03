class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        """
            https://leetcode.com/problems/remove-k-digits/
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the length of num.
        """
        stack = []

        for digit in num:
            while stack and k > 0 and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)

        for _ in range(k):
            stack.pop()

        # remove all leading zero
        ret_string = ''.join(stack).lstrip('0')

        # if the string is empty
        if not ret_string:
            return '0'
        return ret_string


if __name__ == '__main__':
    print(Solution().removeKdigits('1432219', 3))
    print(Solution().removeKdigits("142234", 3))
