// Time Complexity : O(n) as we are travelling throught the array only once
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    string removeKdigits(string num, int k) {
        
         if(k >= num.size())
			return "0";
        
		stack<int> st;
		for(int i=0; i<num.size(); i++){
			int c = num[i] - '0';
			while(!st.empty() && st.top() > c && k  > 0){
				st.pop();
				k--;
			}
			
				st.push(c);
		}

		while(k > 0){
			st.pop();
			k--;
		}

		vector<char> result;
		while(!st.empty()){
			result.push_back(st.top() + '0');
            st.pop();
		}
        int end = result.size() -1;
        
        while(result.size() != 0 && result[end] == '0'){
            result.pop_back();
            end --;
        }

		if(result.size() == 0)
			return "0";
		else {
            
            reverse(result.begin(), result.end());
            string result_str(result.begin(), result.end());
			return result_str;
        }
    }
};