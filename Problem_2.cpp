/**
 * @Time COmplexity:
 * O(N) where N is the length of the string
 * 
 */

/**
 * @Space Complexity:
 * O(N) where N is the length of the given string
 * 
 */

/**
 * @Approach:
 * Monotonic Stack:
 * We need to understand first that removing the largest number from the string 
 * does not guarantee the smallest number. We have to remove the numbers from the
 * left to make the maximum impact. Based on this intution we move from left
 * to right and check if current number is smaller than the number
 * on the top of the stack, we will pop that number out and reduce the count by 1
 * and push the current number on the stack. 
 * 
 * To take care of the preceding zeros we need to observe that if we are getting
 * 0 in the stack and size of stack is 1, then it means it will be a preceding zero.
 * So pop it out.
 * 
 * There will be another case where all the digits in the number will be in increasing
 * order. At that time we just have to remove k elements from the top of teh stack.
 * 
 * After that we have to make our resultant string by popping the stack top into
 * the end of the string. Then reverse it because stack will give us answer in reverse.
 * 
 */

class Solution {
public:
    string removeKdigits(string num, int k) {
        stack<char> s;
        if(num.size() <= k) return "0";
        if(k == 0) return num;
        for(auto n: num){
            while(k > 0 && !s.empty() && s.top() > n){
                k--;
                s.pop();
            }
            s.push(n);
            if(s.size()== 1 && n == '0') s.pop();
        }
        while(k &&!s.empty()){
            k--;
            s.pop();
        }
        
        string result;
        while(!s.empty()){
            result.push_back(s.top());
            s.pop();
        }  
        reverse(result.begin(), result.end());
        if(result.size() == 0) return "0";       
        return result;
    }
};