// Time Complexity : O(n)
// Space Complexity : O(n)
// Any problem you faced while coding this :
//Understanding the removal of elements from the stack was tricky
// Your code here along with comments explaining your approach
//1. Create stack and push string till you find smaller element than the top of the stack
//2. Remove the greater elements. Create the new result string
//3. Pop the excess elements and remove any starting zeroes

class Solution {
public:
    string removeKdigits(string num, int k) {
        //edge
        if(num.length()==0)
            return "";
        
        //logic
        stack<char> char_st;
        char_st.push(num[0]);
        int size = num.length();
        int count =0;
        
        for(int i=1; i<size; i++){
            char temp = char_st.top();
            while(!char_st.empty() && count<k && temp > num[i]){
                char_st.pop();
                if(!char_st.empty()){
                    temp = char_st.top();
                }
                count++;
                if(count ==k){
                    break;
                }
            }
            char_st.push(num[i]);
        }
        
        string result ="";
        int i=char_st.size()-1;
        
        while(!char_st.empty()){
            result.push_back(char_st.top());
            char_st.pop();
        }
        //removing zeroes in front as the string is reversed we are doing it at the back
        while(result.size() >0 && result[result.size()-1] =='0'){
            result.pop_back();
        }
        //reverse string
        if(result.size()>0){
            reverse(result.begin(), result.end());
        }
        
        //removing k-l from the end if we couldnt find enough elements during traversal
        while(result.size()>0 && count<k){
            result.pop_back();
            count++;
        }
        //check if result is empty
        return result==""? "0": result;
    }
    

    
};
