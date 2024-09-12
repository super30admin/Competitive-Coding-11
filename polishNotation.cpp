// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(s) where s is the size of the stack  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<string> stk;
        for(auto str : tokens){
            if(isdigit(str[str.size()-1]))
                stk.push(str);
            else{
                string op = str;
                int aVal = stoi(stk.top());stk.pop();
                int bVal = stoi(stk.top());stk.pop();
                int res;
                if(op == "+") res = aVal+bVal;
                if(op == "-") res = bVal - aVal;
                if(op == "*") res = aVal * bVal;
                if(op == "/") res = (int)bVal/aVal;
                stk.push(to_string(res));
            }
        }
        
        return stoi(stk.top());
    }
};