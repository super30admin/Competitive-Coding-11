/*

Intuition: Push each number in the stack and then pop 2 numbers when we see a operator.
Time Complexity: O(N), N = size of vector
Space Complexity: O(N), N = size of stack


*/
#include<iostream>
#include<vector>
#include<string>
#include<stack>
using namespace std;

int decryptString(vector<string>& input){

    stack<int> stack;

    for ( auto element: input){
        
        if ( element == "-" or element == "+" or element == "/" or element == "*"){
            
            int x = stack.top();
            stack.pop();

            int y = stack.top();
            stack.pop();

            if ( element == "-") stack.push(y-x);
            if ( element == "/") stack.push(y/x);
            if ( element == "*") stack.push(y*x);
            if ( element == "+") stack.push(y+x);

        }

        else{
            stack.push(stoi(element));
        }

    }
    return stack.top();

}   


int main(){
    vector<string> input{"1", "12", "+"};
    // string one = "4";
    // string two = "13";
    // string three = "5";
    // string four = "/";
    // string five = "+";

    // input.push_back(one);
    // input.push_back(two);
    // input.push_back(three);
    // input.push_back(four);
    // input.push_back(five);
    int result = decryptString(input);
    std::cout<<result;
}