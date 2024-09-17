// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this - Yes, couldn't incorporate the negative number situation

class Solution {
private:
// Create number from integer
int get_num(string& str)
{
    int total = 0;

    // Multiply by 10 and add subsequent numbers   
    for(int i = 0; i < str.size(); i++)
    {
        total = (total*10) + (int(str[i])-48);
    }

    return total;
}

int helper(vector<string>& inp_vect)
{
    stack<int> snum;

    // Traverse through the string
    for(int i = 0; i < inp_vect.size(); i++)
    {
        string str = inp_vect[i];

        // Found an operation
        if(str == "+" || str == "-" || str == "/" || str == "*")
        {
            int num1 = snum.top();
            snum.pop();
            int num2 = snum.top();
            snum.pop();

            int result = 0;

            if(str == "+")
                result = num1 + num2;                
            else if(str == "-")
                result = num2 - num1;
            else if(str == "/")
                result = num2 / num1;
            else
                result = num1 * num2;

            snum.push(result);
        }
        // Convert to the number
        else
        {
            int num = get_num(str);
            snum.push(num);
        }            
    }

    return snum.top();
}  
    
public:
    int evalRPN(vector<string>& tokens) {
        return helper(tokens);       
    }
};