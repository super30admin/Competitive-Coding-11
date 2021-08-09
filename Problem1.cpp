// Time Complexity : O(n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Reverse Polish Notation / Postfix

#include<iostream>
#include<vector>
#include<stack>

using namespace std;

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        
        if(tokens.empty())
            return 0;
        
        stack<int> s1;
        
        for(int i = 0; i < tokens.size(); i++){
            
            // if not an operator
            if(tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/"){
                int temp = stoi(tokens[i]);
                s1.push(temp);
            }
            else if(tokens[i] == "+"){
                int op1 = s1.top();
                s1.pop();
                int op2 = s1.top();
                s1.pop();
                s1.push(op2 + op1);
            }
            else if(tokens[i] == "-"){
                int op1 = s1.top();
                s1.pop();
                int op2 = s1.top();
                s1.pop();
                s1.push(op2 - op1);
            }
            else if(tokens[i] == "*"){
                int op1 = s1.top();
                s1.pop();
                int op2 = s1.top();
                s1.pop();
                s1.push(op2 * op1);
            }
            else if(tokens[i] == "/"){      // op2/op1 and not op1/op2, maintain the order
                int op1 = s1.top();
                s1.pop();
                int op2 = s1.top();
                s1.pop();
                s1.push(op2 / op1);
            }
        }
        
        return s1.top();
    }
};