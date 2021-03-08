class Solution:
    
    """
    Description: Evaluate the value of an arithematic expression in Reverse Polish Notation
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Approach:
    1. Use a stack, append values until a operator is found (assign them in a set of given operators for addition, multiplication, difference and division)
    2. Visit every element and if the element is not one of the operator, add them to the stack
    3. if an operator is found, pop the stack twice and get values of 2 elements in front of the operator (for a valid sequence)
    4. after visiting all the elements, we should be left with only one element in the stack which shall be returned as our answer
    """
    
    def evalRPN(self, tokens: List[str]) -> int:
               
        if tokens == None: return 
        
        stack = []
        signs = {"+", "-", "*", "/"}
        
        for elem in tokens:

            if elem not in signs:
                stack.append(int(elem))
            else:
                if len(stack) >= 2:
                    value1 = stack.pop() # -132
                    value2 = stack.pop() # 6
                    # Operate
                    if elem == "+":
                        calc = value1 + value2
                    if elem == "-":
                        calc = value2 - value1
                    if elem == "*":
                        calc = value1 * value2
                    if elem == "/":
                        calc = value2 / value1
                stack.append(int(calc))
                
        return stack.pop()         
        
