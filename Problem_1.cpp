402. Remove K Digits

TC O(n)
SC O(k)

class Solution {
public:
    string removeKdigits(string num, int k) {

        int n = num.size();
        if (n==0) return "0";
        stack <char> s;
        string result = "";
        string result1 = "";

        for (auto &c : num) {
            while (s.size() && (c < s.top()) && k) {
                s.pop();
                k--;
            }
            s.push(c);
        }
        while (k) {
            s.pop();
            k--;
        }
        while (s.size()) {
            result.push_back(s.top());
            s.pop();
        }

        reverse(result.begin(),result.end());
        result.erase(0, result.find_first_not_of('0'));

        return (result == "")? "0":result;
    }
};
