//TC: O(n)
//SC: O(n)


class Solution {
public:
    string removeKdigits(string num, int k) {
        
        string result = "";
        stack<int> s;
        
        
        for(auto ch:num){
            int num = ch - '0';
            
            //using the concept of a monotonic stack (where the digits are in ascending order)
            //pop the element if the stack's top is greater than the current element being considered
            while(!s.empty() && s.top() > num && k>0){
                s.pop();
                k--;
            }
            
            //always push the number into the stack
            s.push(num);
        }
        
        //if k is not zero, then pop the top k elements from the stack
        for(int i=0; i<k; i++){
            s.pop();
        }
        
        
        int stacksize = s.size();
        for(int i =0; i<stacksize; i++){
            //convert the stack to a string
            result = to_string(s.top()) + result; 
            s.pop();
        }
        
        
        int j;
        //remove all initial zeros
        for(j=0; j<result.size(); j++){
            if(result[j] != '0'){
                break;
            }
        }
        
        //if all the numbers are trailing zeros, then return 0 
        if(j == result.size()){
            return "0";
        }
        
        //else return the substring of j
        return result.substr(j);
        
    }
};