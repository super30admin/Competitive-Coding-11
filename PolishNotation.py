class Solution: 
    """
    
            Name : Shahreen Shahjahan Psyche
            Language Used : Python
            Time : O(N)
            Space: O(N)
            Passed All The Test Cases in LC : Yes
            
            Approach : Data Structure - Stack
                       # initialize stack
                       # iterate through the list
                       # push until we encounter an operation
                       # if its an operation then pop the last 2 values of stack and perform the current operation and put back the result into
                         the stack
                       # At the end, theree will be only 1 value remaining in the stack. return that
    
    
    """
    # calculating the value
    def calculate(self, op, first, second):
        
        if op == "+":
            return first + second
        if op == "-":
            return first - second
        if op == "*":
            return first * second
        if op == "/":
            return int(first / second)
        
    
    def evalRPN(self, tokens: List[str]) -> int:
        
        # edge case
        if not tokens:
            return 0
        
        ops = set(["/", "*", "+", "-"])
        stack = []
        
        for i in tokens:
            if i not in ops:
                stack.append(int(i))
            else:
                second = stack.pop()
                first = stack.pop()
                val = self.calculate(i, first, second)
                stack.append(val)
        
        return stack[0]
        
