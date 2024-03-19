class Solution {
    Stack<Integer> st = new Stack<Integer>(); // Initialize a stack to store integers
    
    // Function to perform arithmetic operations based on the operator
    public int operations(int a, int b, String c){
        if(c.equals("+")){ // Addition
            return a + b;
        } else if(c.equals("-")){ // Subtraction
            return a - b;
        } else if(c.equals("*")){ // Multiplication
            return a * b;
        } else { // Division
            return a / b;
        }
    }
    
    // Function to evaluate the Reverse Polish Notation expression
    public int evalRPN(String[] tokens) {
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){ // If the token is an operator
                int b = st.pop(); // Pop the second operand
                int a = st.pop(); // Pop the first operand
                // Perform the operation and push the result back to the stack
                st.push(operations(a, b, tokens[i]));
            } else { // If the token is an operand
                // Convert the token to an integer and push it to the stack
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        // Return the top element of the stack, which is the final result
        return st.peek();
    }
}
