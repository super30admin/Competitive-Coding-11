class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        result_stack= []
        for element in tokens:
            if element not in "+-*/":
                result_stack.append(int(element))
                continue
            recent1 = result_stack.pop()
            recent2 = result_stack.pop()
            result = 0
            if element == "+":
                result = recent1 +recent2
            elif element =="-":
                result = recent2 - recent1
            elif element == "*":
                result = recent1*recent2
            elif element == "/":
                result = int(float(recent2) /recent1)
            
            result_stack.append(result)
        return result_stack.pop()
                
        