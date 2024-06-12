/**
 * @Time Complexity:
 * O(N) where N  is the length of the array.
 * 
 */

/**
 * @Space Complexity:
 * O(N) where N is the length of the array.
 * 
 */


/**
 * @Approach:
 * We need to maintain the order of the last two operands whenever
 * we encounter an operator. So for this we are using a stack where
 * whenever we encounter an operator when we move from left to
 * right in the given array, we pop the top of the stack
 * and store it in a variable and then again pop the top
 * to store the second operand in another variable. Then
 * according to the operator we perform the operation ans push
 * the result into the stack because this result acts as an operand
 * for others.
 * 
 * At the end our result will be stored at the top of the stack.
 * 
 */




class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> s;
        for(auto t: tokens){
            if( t == "+" || t == "-" || t == "*"|| t == "/"){
                int op2 = s.top(); s.pop();
                int op1 = s.top(); s.pop();
                if(t == "+") op1 = op1 + op2;
                else if (t == "-") op1 = op1 - op2;
                else if (t == "*") op1 = op1 * op2;
                else if (t == "/") op1 = op1 / op2;
                s.push(op1);
            } else {
                s.push(stoi(t));
            }
        }
        
        return s.top();
        
    }
};