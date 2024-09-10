//time: O(n)
//space: O(n)
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> stk;
        for(int i = 0; i < tokens.size(); i++) {
            if(tokens[i] == "+") {
                int a = stk.top();
                stk.pop();
                int b = stk.top();
                stk.pop();
                int result = a + b;
                stk.push(result);
            }
            else if(tokens[i] == "-") {
                int a = stk.top();
                stk.pop();
                int b = stk.top();
                stk.pop();
                int result = b - a;
                stk.push(result);
            }
            else if(tokens[i] == "*") {
                int a = stk.top();
                stk.pop();
                int b = stk.top();
                stk.pop();
                int result = a * b;
                stk.push(result);
            }
            else if(tokens[i] == "/") {
                int a = stk.top();
                stk.pop();
                int b = stk.top();
                stk.pop();
                int result = b / a;
                stk.push(result);
            }
            else {
                stk.push(stoi(tokens[i]));
            }
        }
        return stk.top();
    }
};