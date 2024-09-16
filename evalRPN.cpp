//TC: O(n)
//SC: O(n)

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        
        if(tokens.empty())
            return 0;
        
        stack<int> s;
        int len = tokens.size();
        
        for(int i=0; i<len; i++){
            
            if(tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/")
                s.push(stoi(tokens[i]));
            else{
                int op2 = s.top();
                s.pop();
                int op1 = s.top();
                s.pop();
                if(tokens[i] == "+")
                    s.push(op1 + op2);
                if(tokens[i] == "-")
                    s.push(op1 - op2);
                if(tokens[i] == "*")
                    s.push(op1 * op2);
                if(tokens[i] == "/")
                    s.push(op1/op2);
            }
            
        }
        
        return s.top();
        
        
    }
};