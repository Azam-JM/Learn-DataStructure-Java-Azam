class Solution {
    public boolean isValid(String s) {
        // Leetcode 20: https://leetcode.com/problems/valid-parentheses/
        
        // Create a stack to store opening parentheses
        Stack<Character> st = new Stack<Character>();
        
        // Iterate through each character in the input string
        for(int i = 0; i < s.length(); i++) {
            // If the character is an opening parenthesis, push it onto the stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
            } else {
                // If the stack is empty and we encounter a closing parenthesis, return false
                if(st.empty()) {
                    return false;
                }
                
                // Check if the current closing parenthesis matches the top of the stack
                if(s.charAt(i) == ')' && st.peek() == '(') {
                    // If it matches, pop the opening parenthesis from the stack
                    st.pop();
                } else if(s.charAt(i) == ']' && st.peek() == '[') {
                    // Similarly, for square brackets
                    st.pop();
                } else if(s.charAt(i) == '}' && st.peek() == '{') {
                    // Similarly, for curly braces
                    st.pop();
                } else {
                    // If the closing parenthesis does not match the top of the stack, return false
                    return false;
                }
            }
        }
        
        // After iterating through the string, if the stack is empty, return true
        // Otherwise, return false (there are unmatched opening parentheses)
        return st.empty();
    }
}

// Approach 2
class Solution2 {
    public boolean isValid(String s) {
        // Create a stack to store characters
        Stack<Character> st = new Stack<Character>();

        // Iterate through each character in the input string
        for(int i = 0; i < s.length(); i++) {
            // If the character is an opening parenthesis, push its corresponding closing parenthesis onto the stack
            if(s.charAt(i) == '{') {
                st.push('}');
            } else if(s.charAt(i) == '[') {
                st.push(']');
            } else if(s.charAt(i) == '(') {
                st.push(')');
            } else {
                // If the stack is not empty and the current character matches the top of the stack,
                // pop the top character from the stack (indicating a matched pair)
                if(!st.empty() && (s.charAt(i) == st.peek())) {
                    st.pop();
                } else {
                    // If the stack is empty or the current character does not match the top of the stack,
                    // return false (indicating an unmatched closing parenthesis)
                    return false;
                }
            }
        }
        // After iterating through the string, if the stack is empty, return true
        // Otherwise, return false (there are unmatched opening parentheses)
        return st.empty();    
    }
}

