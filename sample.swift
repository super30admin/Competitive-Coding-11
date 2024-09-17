// Time Complexity :0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func minSwaps(_ s: String) -> Int {
        if s == nil || s.count == 0 {
            return 0
        }
        var countClosingBraces = 0
        var countOpeningBraces = 0
        for char in s {
            if char == "]" {
                if countOpeningBraces > 0 {
                    countOpeningBraces -= 1
                    } else {
                    countClosingBraces += 1
                }  
            } else {
                countOpeningBraces += 1
            }
        }
        return (countClosingBraces + 1)/2
    }
