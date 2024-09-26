
// Time Complexity : O(n)
// Space Complexity : O(n)
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
//1. Crete stack and keep pushing until you find an operator.
//2. Pop last two elements, operate and then push the result.
//3. Return the top of the stack
class Solution {
public:
    bool is_num(string str){
        if(str!="+" && str!="-"&& str!="*"&& str!="/" )
            return true;
        
        return false;
    }
    
    int operate(int var1, int var2, string operation){
        int result;
        if(operation == "+"){
            result = var1+var2;
        }
        if(operation == "-"){
            result = var1-var2;
        }
        if(operation == "*"){
            result = var1*var2;
        }
        if(operation == "/"){
            result = var1/var2;
        }
        return result;
    }
    
    int evalRPN(vector<string>& tokens) {
        //edge
        if(tokens.size()==0)
            return 0;
        //logic
        stack<int> int_st;
        int i=0;
        while(!is_num(tokens[i])){
            i++;
        }
        int_st.push(stoi(tokens[i]));
        i++;
        int size = tokens.size();
        
        int var1=0, var2=0;
        while(i<size){
            if(is_num(tokens[i])){
                int_st.push(stoi(tokens[i]));
            }else{
                if(!int_st.empty()){
                    var2 = int_st.top();
                    int_st.pop();
                }
                if(!int_st.empty()){
                    var1 = int_st.top();
                    int_st.pop();
                }
                int result = operate(var1, var2,tokens[i] );
                int_st.push(result);
            }   
            i++;
        }
        
        return int_st.top();
    }
};
