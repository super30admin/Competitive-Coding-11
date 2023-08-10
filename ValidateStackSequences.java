// TC = O(2n) ->O(n)
/* Approach - put the 'pushed' array element to stack only if they aren't equal to thr leftmost element of the 'popped' array. 
If the elements are equal move the pointer over 'popped' array so that next element becomes new leftmost element
At the end if the 'push' stack is empty return true else return false. */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pushSt = new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            pushSt.push(pushed[i]);
            while(!pushSt.isEmpty() && pushSt.peek()==popped[j]){
                pushSt.pop();   
                j++; 
            }

        }
        return pushSt.isEmpty();
    }
}
// class Solution { // this code has error
//     public boolean validateStackSequences(int[] pushed, int[] popped) {
//         Stack<Integer> pushSt = new Stack<>();
//         Stack<Integer> popSt = new Stack<>();
//         for(int i=popped.length-1;i>=0;i--){
//             popSt.push(popped[i]);
//         } 
//         System.out.println(popSt+" "+popSt.peek());
//         for(int i=0;i<pushed.length;i++){
//             pushSt.push(pushed[i]);
//             while(!pushSt.isEmpty() && !popSt.isEmpty() && pushSt.peek()==popSt.peek()){
//                 pushSt.pop();
//                 popSt.pop();
//             }
//         }
//         return pushSt.isEmpty();
//     }
// }