// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

//https://leetcode.com/problems/remove-k-digits/

public class Solution {
    public string RemoveKdigits(string num, int k) {
        List<char> result = new List<char>();

    foreach (char digit in num)
    {
        while (result.Count > 0 && k > 0 && result[^1] > digit) // ^1 gets the last element
        {
            result.RemoveAt(result.Count - 1);
            k--;
        }
        result.Add(digit);
    }

    // Remove remaining digits if needed
    result = result.Take(result.Count - k).ToList(); // Remove extra from the end if k > 0

    // Convert to string and remove leading zeros
    string finalResult = string.Join("", result).TrimStart('0');
    return string.IsNullOrEmpty(finalResult) ? "0" : finalResult;
        
    }
}