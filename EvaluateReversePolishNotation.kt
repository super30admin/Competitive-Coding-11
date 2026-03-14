// In this problem we process each token and add it to the stack, if its a number we add it to the stack, if its an operator then we pop last two elements, process the values and then add it back to the stack
// Time complexity = O(n) // each token is processed once
// Space complexity = O(n)

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for(token in tokens){
            when(token) {
                "+" -> {
                    stack.addLast(stack.removeLast() + stack.removeLast())
                }
                "-" -> {
                    val b = stack.removeLast()
                    val a = stack.removeLast()
                    stack.addLast(a - b)
                }
                "*" -> {
                    stack.addLast(stack.removeLast() * stack.removeLast())
                }
                "/" -> {
                    val b = stack.removeLast()
                    val a = stack.removeLast()
                    stack.addLast(a / b)
                }
                else -> {
                    stack.addLast(token.toInt())
                }
            }
        }

        return stack.removeLast()
    }
}