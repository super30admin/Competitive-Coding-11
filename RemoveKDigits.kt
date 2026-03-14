// In this problem we need to extract smaller number, so we remove larger digits that appear before smaller digits. To solve this problem we use monotonic increasing stack. We traverse each digit in num, add the digit to the stack. 
// If the current digit is less than top of stack and if we have remaining k digits we pop it. 
// Time complexity = O(n) -- each digit is pushed and popped at most once. 
//Space complexity = O(n)


class Solution {
    fun removeKdigits(num: String, k: Int): String {
        val stack = ArrayDeque<Char>()

        var remainingK = k

        for(c in num) {
            while(stack.isNotEmpty() && remainingK > 0 && stack.last() > c) {
                stack.removeLast()
                remainingK--
            }
            stack.addLast(c)
        }

        repeat(remainingK) {
            if(stack.isNotEmpty()) stack.removeLast()
        }

        val sb = StringBuilder()
        var leadingZero = true
        for(c in stack) {
            if(leadingZero && c =='0') continue
            leadingZero = false
            sb.append(c)
        }

        return if(sb.isEmpty()) "0" else sb.toString()

    }
}